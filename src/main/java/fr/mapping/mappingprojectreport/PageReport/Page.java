package fr.mapping.mappingprojectreport.PageReport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.mapping.mappingprojectreport.Report.Report;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Page implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namePage;
    private String idPage;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idReport")
    private Report report;
}
