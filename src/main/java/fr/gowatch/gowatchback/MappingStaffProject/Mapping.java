package fr.gowatch.gowatchback.MappingStaffProject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.gowatch.gowatchback.Access.AccessProjectId;
import fr.gowatch.gowatchback.Project.Project;
import fr.gowatch.gowatchback.Staff.AppUser;
import fr.gowatch.gowatchback.Staff.Staff;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Mapping implements Serializable {
    @EmbeddedId
    private MappinStaffProjectId mappinStaffProjectId;

    @ManyToOne
    @JoinColumn(insertable = false,updatable = false,name = "staff",referencedColumnName = "iris")

    private Staff staff;
    @ManyToOne
    @JoinColumn(insertable = false,updatable = false,name = "project",referencedColumnName = "idProject")
    private Project project;
}
