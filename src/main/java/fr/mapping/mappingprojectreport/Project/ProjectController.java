package fr.mapping.mappingprojectreport.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getPageReports() {
        return projectService.getAllProjects();
    }

    @GetMapping(path = "{idProject}")
    public Project getNameProjectById(@PathVariable("idProject") Long idProject) {
        return this.projectService.getProjectById(idProject);
    }



}
