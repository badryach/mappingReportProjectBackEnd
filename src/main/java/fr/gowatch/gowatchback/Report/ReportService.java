package fr.gowatch.gowatchback.Report;

import fr.gowatch.gowatchback.Project.Project;
import fr.gowatch.gowatchback.Project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final ProjectRepository projectRepository;
    @Autowired
    public ReportService(ReportRepository reportRepository,ProjectRepository projectRepository)
    {
        this.reportRepository=reportRepository;
        this.projectRepository=projectRepository;
    }
    public Optional<Report> getReport(Long idReport){

      return   this.reportRepository.findById(idReport);
    }
    public void addReport(Report report,Long idProject)
    {

       Optional<Project> exis= projectRepository.findById(idProject);
       if(exis.isPresent())
       {

           report.setProject(exis.get());
       }

        reportRepository.save(report);
    }
    public List<Report> getAllReports()
    {
        return reportRepository.findAll();
    }
    @Transactional
    public List<Report> getReportPages (Long idReport)
    {
        return this.reportRepository.getReportByIdProject(idReport);
    }

    @Transactional
    public Report updateReport(Long id, Report report)
    {
        Report report1 = this.reportRepository.getById(id);
       report1.setLink(report.getLink());
        return this.reportRepository.save(report1);
    }
    @Transactional
    public void deleteReport(Long id) {
        this.reportRepository.deleteById(id);
    }
    public List<Report> getReports(Long id)
    {
       return this.reportRepository.getReports(id);
    }


}
