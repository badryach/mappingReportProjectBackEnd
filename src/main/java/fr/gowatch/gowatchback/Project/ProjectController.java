package fr.gowatch.gowatchback.Project;

import fr.gowatch.gowatchback.PageReport.Page;
import fr.gowatch.gowatchback.Report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "project")
public class ProjectController {

    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService)
    {
        this.projectService=projectService;
    }

    @GetMapping
    public List<Project> getPageReports(){
        return projectService.getAllProjects();
    }

    @GetMapping(path = "{idProject}")
    public Project getNameProjectById(@PathVariable("idProject") Long idProject)
    {
        return this.projectService.getProjectById(idProject);
    }

    @GetMapping(path = "/getApproved/{username}")
    public List<Project> getApprovedProject(@PathVariable("username") String username)
    {
        System.out.println(username);
        return this.projectService.getApprovedProject(username);
    }

}
