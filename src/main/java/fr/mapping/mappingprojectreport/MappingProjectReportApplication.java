package fr.mapping.mappingprojectreport;

import fr.mapping.mappingprojectreport.PageReport.PageRepository;
import fr.mapping.mappingprojectreport.Project.ProjectService;
import fr.mapping.mappingprojectreport.Report.ReportRepository;
import fr.mapping.mappingprojectreport.Roles.AppRole;
import fr.mapping.mappingprojectreport.Roles.AppRoleRepository;
import fr.mapping.mappingprojectreport.Staff.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class MappingProjectReportApplication extends SpringBootServletInitializer implements CommandLineRunner {
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AppRoleRepository appRoleRepository;



    public static void main(String[] args) {
        SpringApplication.run(MappingProjectReportApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MappingProjectReportApplication.class);
    }

    @Bean
    BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void run(String... args) throws Exception {
        AppRole agentRole = new AppRole(1L, "AGENT");
        AppRole adminRole = new AppRole(2L, "ADMIN");
        AppRole userRole = new AppRole(3L, "USER");
        AppRole moderatorRole = new AppRole(4L, "MODERATOR");
        AppRole customerRole = new AppRole(5L, "CUSTOMER");

        appRoleRepository.save(agentRole);
        appRoleRepository.save(adminRole);
        appRoleRepository.save(userRole);
        appRoleRepository.save(moderatorRole);
        appRoleRepository.save(customerRole);

    }
}
