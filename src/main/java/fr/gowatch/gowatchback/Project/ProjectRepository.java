package fr.gowatch.gowatchback.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    public List<Project> findAllByOrderByIdProjectAsc();
    @Query("select p from Project p inner join p.accessProject a inner join a.appUser u where u.username=:username and a.status=1 ")
    public List<Project> getApprovedProject(String username);
}
