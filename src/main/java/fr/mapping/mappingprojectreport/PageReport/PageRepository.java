package fr.mapping.mappingprojectreport.PageReport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {
    @Query("select p from Page p where p.report.idReport = :idReport")
    List<Page> getPagesByIdReport(@Param("idReport") Long idreport);
}
