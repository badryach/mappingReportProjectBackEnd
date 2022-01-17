package fr.gowatch.gowatchback.Project;

import com.fasterxml.jackson.annotation.*;
import fr.gowatch.gowatchback.Access.AccessProject;
import fr.gowatch.gowatchback.Account.Account;
import fr.gowatch.gowatchback.BusinessUnit.BusnessUnit;
import fr.gowatch.gowatchback.MappingStaffProject.Mapping;

import fr.gowatch.gowatchback.Report.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
@Setter @Getter @AllArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idProject")
public class Project  implements Serializable {
    @Id
    private Long idProject;
    private String nameProject;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    @JsonIgnore
    private Collection<AccessProject> accessProject;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    @JsonIgnore
    private Collection<Mapping> mappingStaffProjects;
    @ManyToOne
    @JoinColumn(name = "idAccount")
    private Account account;
    public Project()
    {

    }
}
