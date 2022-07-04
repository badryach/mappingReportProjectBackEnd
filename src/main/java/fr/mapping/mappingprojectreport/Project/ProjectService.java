package fr.mapping.mappingprojectreport.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return this.projectRepository.findAllByOrderByIdProjectAsc();
    }

    public Project getProjectById(Long id) {
        Optional<Project> exis = projectRepository.findById(id);
        Project project = new Project();
        if (exis.isPresent()) {
            project = exis.get();
        }
        return project;
    }

    ;



}
