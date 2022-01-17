package fr.gowatch.gowatchback.Staff;


import com.fasterxml.jackson.annotation.*;
import fr.gowatch.gowatchback.Access.AccessProject;
import fr.gowatch.gowatchback.Roles.AppRole;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    @Column(unique = true)
    private String username;
    private String irisUser;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean actived;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles= new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
    private Collection<AccessProject> accessProject = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "iris", referencedColumnName = "iris")
    private Staff iris;



}
