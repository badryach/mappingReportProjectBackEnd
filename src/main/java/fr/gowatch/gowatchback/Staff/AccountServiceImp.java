package fr.gowatch.gowatchback.Staff;

import fr.gowatch.gowatchback.Roles.AppRole;
import fr.gowatch.gowatchback.Roles.AppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class AccountServiceImp implements AccountService{
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private StaffService staffService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser saveUser(String username,String iris, String password, String confirmedPassword) {
        AppUser user= appUserRepository.findByUsername(username);
        Staff staffOptional = staffService.getStaff(username);

        if(staffOptional==null) throw new RuntimeException("Cette adresse n'existe pas dans nos bases. Merci de voir avec un administrateur");
        if(user!=null) throw new RuntimeException("Utilisateur existe déja");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Merci de confirmer votre mot de passe");
        if(!iris.equals(staffOptional.getIris())) throw new RuntimeException("Le iris saisi n'existe pas dans nos bases. Merci de voir avec un administrateur");
        AppUser appUser= new AppUser() ;
        appUser.setUsername(username);
        appUser.setFirstName(staffOptional.getFirstName());
        appUser.setLastName(staffOptional.getLastName());
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setIrisUser(staffOptional.getIris());
        appUser.setIris(staffOptional);
        appUser.setActived(true);
        appUserRepository.save(appUser);


         if (staffOptional.getCodeJob().contains("CR")  || staffOptional.getCodeJob().contains("CRP") || staffOptional.getCodeJob().contains("CP REP"))
        {
            addRoleToUser(username,"MODERATOR");
        }
         else if (staffOptional.getCodeJob().equals("codir"))
         {
             addRoleToUser(username,"COMEX");
         }
        else if (staffOptional.getCodeJob().equals("CLT"))
        {
            addRoleToUser(username,"CUSTOMER");
        }
        else if (staffOptional.getCodeJob().equals("BITEAM") ||  staffOptional.getUserName().equals("yhajjaji@webhelp.fr")  ||  staffOptional.getUserName().equals("sabouliatim@webhelp.fr") || staffOptional.getUserName().equals("byachou@webhelp.fr"))
        {

            addRoleToUser(username,"ADMIN");
        }
        else
        {
            addRoleToUser(username,"USER");
        }
        return appUser;
    }



    @Override
    public AppRole saveRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser= appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }
}
