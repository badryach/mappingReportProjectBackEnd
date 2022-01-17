package fr.gowatch.gowatchback.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository  extends JpaRepository<Report,Long> {
    @Query("select r from Report r where r.project.idProject = :idProject")
    List<Report> getReportByIdProject(@Param("idProject") Long idProject);
    @Query("select r from Report r inner join r.project p inner join  p.accessProject a where a.status=1 and a.accessProjectId.user=:idUser")
    List<Report> getReports (@Param("idUser") Long idUser);
    
}
