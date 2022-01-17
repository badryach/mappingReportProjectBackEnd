package fr.gowatch.gowatchback.Report;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.gowatch.gowatchback.PageReport.Page;
import fr.gowatch.gowatchback.Project.Project;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Report implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReport;
    @Column(length = 500)
    private String link;
    @JsonIgnore
    @OneToMany(mappedBy = "report",
    cascade =CascadeType.ALL)
    private List<Page> pages;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProject")
    private Project project;
}
