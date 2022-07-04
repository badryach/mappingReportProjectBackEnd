package fr.mapping.mappingprojectreport.PageReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "page")
public class PageController {
    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @PostMapping(path = "{idReport}")
    public void addPage(@RequestBody Page page, @PathVariable("idReport") Long idReport) {
        this.pageService.addPage(page, idReport);
    }

    @GetMapping
    public List<Page> getPageReports() {
        return pageService.getAllPageReports();
    }

    @GetMapping(path = "{idReport}")
    public List<Page> getReportPages(@PathVariable("idReport") Long idReport) {
        return this.pageService.getAllPagesByIdReport(idReport);
    }

    @GetMapping(path = "get/{id}")
    public Page getPage(@PathVariable("id") Long id) {
        return this.pageService.getPageById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deletePage(@PathVariable("id") Long id) {
        this.pageService.deletePage(id);
    }

    @PutMapping(path = "{id}")
    public Page updatePage(@PathVariable("id") Long id, @RequestBody Page page) {
        return this.pageService.updateReport(id, page);
    }

}
