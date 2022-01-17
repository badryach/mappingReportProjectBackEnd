package fr.gowatch.gowatchback.Access;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.gowatch.gowatchback.Project.Project;
import fr.gowatch.gowatchback.Staff.AppUser;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class AccessProject implements Serializable {
    @EmbeddedId
    private AccessProjectId accessProjectId;
    private int status;
    private Date dateRequest;

    @ManyToOne
    @JoinColumn(insertable = false,updatable = false,name = "user",referencedColumnName = "id")
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(insertable = false,updatable = false,name = "project",referencedColumnName = "idProject")
    private Project project;

}
