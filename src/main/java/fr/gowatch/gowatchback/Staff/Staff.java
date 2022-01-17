package fr.gowatch.gowatchback.Staff;

import com.fasterxml.jackson.annotation.*;
import fr.gowatch.gowatchback.Access.AccessProject;
import fr.gowatch.gowatchback.MappingStaffProject.Mapping;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Table
@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="iris")

public class Staff implements Serializable {

    @Id
    private String iris;
    private String lastName;
    private String firstName;
    private String userName;
    private String codeJob;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "manager")
    private Staff manager;
    @JsonIgnore
    @OneToMany(mappedBy = "manager",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Staff> staffs;
    @JsonIgnore
    @OneToOne(mappedBy = "iris")
    private AppUser appUser;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
    private Collection<Mapping> mappingStaffProjects = new ArrayList<>();

}
