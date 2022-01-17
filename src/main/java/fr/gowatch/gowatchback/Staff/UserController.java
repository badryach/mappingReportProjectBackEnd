package fr.gowatch.gowatchback.Staff;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private StaffService staffService;

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm userForm)
    {

        return  accountService.saveUser(userForm.getUsername(),userForm.getIris(),userForm.getPassword(),userForm.getConfirmedPassword());
    }

    
    @GetMapping("/getUser/{username}")
    public Staff getStaff(@PathVariable("username") String username)
    {
        return  staffService.getStaff(username);
    }

    @GetMapping("/getStaff/{iris}")
    public Staff getStaffInfo(@PathVariable("iris") String iris)
    {
        return staffService.getStaffInfo(iris);
    }
    @GetMapping("/getUserInfo/{username}")
    public AppUser getUserInfo(@PathVariable("username") String username)
    {
        return accountService.loadUserByUsername(username);
    }
    @GetMapping("/getAllUsers")
    public List<AppUser> getAllUsers()
    {
        return this.accountService.getAllUsers();
    }


    @GetMapping("/getUsers")
    public List<Staff> getUsers()
    {
        return this.staffService.getUsers();
    }

}

class UserForm
{
    private  String username;
    private String iris;
    private String password;
    private String confirmedPassword;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }
    public String getIris() { return iris;}
}