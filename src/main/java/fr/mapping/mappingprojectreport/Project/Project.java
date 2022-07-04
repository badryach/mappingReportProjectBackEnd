package fr.mapping.mappingprojectreport.Project;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import fr.mapping.mappingprojectreport.PageReport.Page;
import fr.mapping.mappingprojectreport.Staff.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProject")
public class Project implements Serializable {
    @Id
    private Long idProject;
    private String nameProject;
    @JsonIgnore
    @OneToMany(mappedBy = "project",
            cascade = CascadeType.ALL)
    private List<AppUser> users;

    public Project() {

    }
}
