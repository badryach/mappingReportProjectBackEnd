package fr.mapping.mappingprojectreport.Report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "report")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PutMapping(path = "updateReport/{id}")
    public Report updateReport(@PathVariable("id") Long id, @RequestBody Report report) {
        return this.reportService.updateReport(id, report);
    }

    @PostMapping(path = "{idProject}")
    public void addReport(@RequestBody Report report, @PathVariable("idProject") Long idProject) {
        this.reportService.addReport(report, idProject);
    }

    @GetMapping
    public List<Report> getAllReports() {
        return this.reportService.getAllReports();
    }

    @GetMapping(path = "{idProject}")
    public List<Report> getReportPages(@PathVariable("idProject") Long idProject) {
        return this.reportService.getReportPages(idProject);
    }

    @GetMapping(path = "getReport/{idReport}")
    public Optional<Report> getReport(@PathVariable("idReport") Long idReport) {
        return this.reportService.getReport(idReport);
    }

    @DeleteMapping(path = "{id}")
    public void deleteReport(@PathVariable("id") Long id) {
        this.reportService.deleteReport(id);
    }

}
