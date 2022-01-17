package fr.gowatch.gowatchback.PageReport;

import fr.gowatch.gowatchback.Project.Project;
import fr.gowatch.gowatchback.Report.Report;
import fr.gowatch.gowatchback.Report.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

public class PageService {

    private final PageRepository pageRepository;
    private final ReportRepository reportRepository;
    @Autowired
    public PageService(PageRepository pageRepository, ReportRepository reportRepository) {
        this.pageRepository = pageRepository;
        this.reportRepository = reportRepository;
    }
    public Page getPageById (Long id) {
        Optional<Page> exis= pageRepository.findById(id);
        Page page = new Page();
        if(exis.isPresent())
        {
            page= exis.get();
        }
        return page;
    };

    public void addPage(Page page) {
        pageRepository.save(page);
    }
    public List<Page> getAllPageReports() {
        return pageRepository.findAll();
    }

    public List<Page> getAllPagesByIdReport(Long idReport)
    {
        return this.pageRepository.getPagesByIdReport(idReport);
    }
    public void addPage(Page page, Long idPage)
    {

        Optional<Report> exis= reportRepository.findById(idPage);
        if(exis.isPresent())
        {

            page.setReport(exis.get());
        }

        pageRepository.save(page);
    }
    @Transactional
    public Page updateReport(Long id, Page page)
    {
        Page p = this.pageRepository.getById(id);
        p.setIdPage(page.getIdPage());
        return this.pageRepository.save(p);
    }

    @Transactional
    public void deletePage(Long id) {
        this.pageRepository.deleteById(id);
    }
}
