package fr.gowatch.gowatchback.Access;

import fr.gowatch.gowatchback.Project.Project;
import fr.gowatch.gowatchback.Staff.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessProjectRepository extends JpaRepository<AccessProject,Long> {
    public List<AccessProject> findAccessProjectByAppUserOrderByDateRequestDesc (AppUser appUser);
    public  AccessProject getAccessProjectByAccessProjectId_ProjectAndAccessProjectId_User(Long project,Long user);
    public List<AccessProject> getAccessProjectsByStatusOrderByDateRequestDesc(int status);
}
