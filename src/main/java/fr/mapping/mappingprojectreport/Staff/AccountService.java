package fr.mapping.mappingprojectreport.Staff;

import fr.mapping.mappingprojectreport.Roles.AppRole;

import java.util.List;

public interface AccountService {
    public AppUser saveUser(String username, String iris, String password, String confirmedPassword);

    public AppRole saveRole(AppRole role);

    public AppUser loadUserByUsername(String username);

    public void addRoleToUser(String username, String rolename);

    public List<AppUser> getAllUsers();
}
