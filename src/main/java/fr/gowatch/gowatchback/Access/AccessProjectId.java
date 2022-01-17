package fr.gowatch.gowatchback.Access;

import fr.gowatch.gowatchback.Project.Project;
import fr.gowatch.gowatchback.Staff.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccessProjectId implements Serializable {
 private Long project;
 private Long user;

}
