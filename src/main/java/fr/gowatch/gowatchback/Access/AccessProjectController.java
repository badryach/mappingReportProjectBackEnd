package fr.gowatch.gowatchback.Access;

import fr.gowatch.gowatchback.PageReport.Page;
import fr.gowatch.gowatchback.Project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "accessProject")
public class AccessProjectController {
    private AccessProjectService accessProjectService;

    @Autowired
    public AccessProjectController(AccessProjectService accessProjectService)
    {
        this.accessProjectService= accessProjectService;
    }
    @PostMapping(path="{iris}")
    public void addAccess(@PathVariable("iris") String iris,@RequestBody Project project)
    {
        this.accessProjectService.addAccess(iris,project);
    }
    @PutMapping(path="/approve/{idProject}")
    public void approveAccess(@PathVariable("idProject")  Long idProject,@RequestBody Long idUser)
    {
        this.accessProjectService.approveAccess(idProject,idUser);
    }
    @PostMapping(path="/refus/{idProject}")
    public void refusAccess(@PathVariable("idProject")  Long idProject,@RequestBody Long idUser)
    {
        this.accessProjectService.refusAccess(idProject,idUser);
    }
    @DeleteMapping(path="{id}")
    public void deleteAccess(@PathVariable("id")  Long id)
    {
        this.accessProjectService.deleteAccess(id);
    }

    @GetMapping(path = "/getAccess/{idUser}")
    public List<AccessProject> getAccess(@PathVariable("idUser") String idUser){
        List<AccessProject> list1 =this.accessProjectService.getAccess(idUser);

        return list1;

    }
    @GetMapping(path = "/getAllAccess")
    public List<AccessProject> getAllAccess(){
        return   this.accessProjectService.getAllAccess();

    }
    @GetMapping(path = "/getAccessToBeApproved")
    public List<AccessProject> getAccessToBeApproved(){
        return   this.accessProjectService.getAccessToBeApproved();

    }
    @PutMapping(path="{id}")
    public AccessProject updateAccess(@PathVariable("id") Long id,@RequestBody AccessProject accessProject)
    {
        return  this.accessProjectService.updateAccess(id,accessProject);
    }
}
