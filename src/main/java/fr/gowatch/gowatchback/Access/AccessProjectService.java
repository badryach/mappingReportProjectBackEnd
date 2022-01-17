package fr.gowatch.gowatchback.Access;

import fr.gowatch.gowatchback.Project.Project;
import fr.gowatch.gowatchback.Staff.AppUser;
import fr.gowatch.gowatchback.Staff.AppUserRepository;
import fr.gowatch.gowatchback.Staff.Staff;
import fr.gowatch.gowatchback.Staff.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccessProjectService {
    @Autowired
    private final AccessProjectRepository accessProjectRepository;

    @Autowired
    private final AppUserRepository appUserRepository;

    @Autowired
    private final StaffRepository staffRepository;


    @Autowired
    public AccessProjectService(AccessProjectRepository accessProjectRepository, AppUserRepository appUserRepository, StaffRepository staffRepository) {
        this.accessProjectRepository = accessProjectRepository;
        this.appUserRepository = appUserRepository;
        this.staffRepository = staffRepository;
    }

    public void addAccess(String iris, Project project) {
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Staff staff= staffRepository.findByIris(iris);
        AccessProject accessProject= new AccessProject();
       AppUser appUser= appUserRepository.findByIris(staff);

        String currentTime = sdf.format(dt);
        accessProject.setProject(project);
        accessProject.setDateRequest(dt);
        accessProject.setStatus(0);
        AccessProjectId accessProjectId= new AccessProjectId();
        accessProjectId.setUser(appUser.getId());
        accessProjectId.setProject(accessProject.getProject().getIdProject());
        accessProject.setAccessProjectId(accessProjectId);
        this.accessProjectRepository.save(accessProject);
    }
    public List<AccessProject> getAllAccess() {
        return this.accessProjectRepository.findAll(Sort.by(Sort.Direction.DESC, "DateRequest"));
    }

    public List<AccessProject> getAccessToBeApproved() {
        return this.accessProjectRepository.getAccessProjectsByStatusOrderByDateRequestDesc(0);
    }

    public List<AccessProject> getAccess(String idUser)
    {
        Staff staff= this.staffRepository.findByIris(idUser);
        AppUser appUser= this.appUserRepository.findByIris(staff);
        return this.accessProjectRepository.findAccessProjectByAppUserOrderByDateRequestDesc(appUser);

    }


    @Transactional
    public AccessProject updateAccess(Long id, AccessProject access)
    {
        AccessProject accessProject = this.accessProjectRepository.getById(id);
        accessProject.setProject(access.getProject());
        return this.accessProjectRepository.save(accessProject);
    }

    @Transactional
    public void deleteAccess(Long id) {
        this.accessProjectRepository.deleteById(id);
    }

    public void approveAccess(Long idProject,Long IdUser ) {
        AccessProject accessProject1= this.accessProjectRepository.getAccessProjectByAccessProjectId_ProjectAndAccessProjectId_User(Long.valueOf(idProject), Long.valueOf(IdUser));
        accessProject1.setStatus(1);
        this.accessProjectRepository.save(accessProject1);
    }

    public void refusAccess(Long idProject,Long idUser ) {
        AccessProject accessProject1= this.accessProjectRepository.getAccessProjectByAccessProjectId_ProjectAndAccessProjectId_User(Long.valueOf(idProject), Long.valueOf(idUser));
        accessProject1.setStatus(-1);
        this.accessProjectRepository.save(accessProject1);
    }
}
