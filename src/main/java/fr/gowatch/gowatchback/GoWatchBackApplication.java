package fr.gowatch.gowatchback;

import fr.gowatch.gowatchback.Access.AccessProject;
import fr.gowatch.gowatchback.Access.AccessProjectRepository;
import fr.gowatch.gowatchback.Access.AccessProjectService;
import fr.gowatch.gowatchback.PageReport.Page;
import fr.gowatch.gowatchback.PageReport.PageRepository;
import fr.gowatch.gowatchback.Project.Project;
import fr.gowatch.gowatchback.Project.ProjectRepository;
import fr.gowatch.gowatchback.Project.ProjectService;
import fr.gowatch.gowatchback.Report.Report;
import fr.gowatch.gowatchback.Report.ReportRepository;
import fr.gowatch.gowatchback.Roles.AppRole;
import fr.gowatch.gowatchback.Roles.AppRoleRepository;
import fr.gowatch.gowatchback.Staff.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.stream.Stream;


@SpringBootApplication
public class GoWatchBackApplication extends SpringBootServletInitializer implements CommandLineRunner {
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

    @Autowired
    private AccessProjectService accessProjectService;

    @Autowired
    private AccessProjectRepository accessProjectRepository;
    public static void main(String[] args) {
        SpringApplication.run(GoWatchBackApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GoWatchBackApplication.class);
    }

   @Bean
    BCryptPasswordEncoder getBCPE()
    {
         return  new BCryptPasswordEncoder();
    }


    @Override
    public void run(String... args) throws Exception {
        AppRole agentRole= new AppRole(1L,"AGENT");
        AppRole adminRole= new AppRole(2L,"ADMIN");
        AppRole userRole= new AppRole(3L,"USER");
        AppRole moderatorRole= new AppRole(4L,"MODERATOR");
        AppRole customerRole= new AppRole(5L,"CUSTOMER");
        AppRole comexRole= new AppRole(6L,"COMEX");

        appRoleRepository.save(agentRole);
        appRoleRepository.save(adminRole);
        appRoleRepository.save(userRole);
        appRoleRepository.save(moderatorRole);
        appRoleRepository.save(customerRole);
        appRoleRepository.save(comexRole);

    }
}
