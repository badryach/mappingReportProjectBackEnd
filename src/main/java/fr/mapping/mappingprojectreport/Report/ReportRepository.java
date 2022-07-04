package fr.mapping.mappingprojectreport.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query("select r from Report r where r.project.idProject = :idProject")
    List<Report> getReportByIdProject(@Param("idProject") Long idProject);

}
