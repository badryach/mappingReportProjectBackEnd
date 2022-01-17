package fr.gowatch.gowatchback.Account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.gowatch.gowatchback.BusinessUnit.BusnessUnit;
import fr.gowatch.gowatchback.Country.Country;
import fr.gowatch.gowatchback.Project.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idAccount;
    private String nameAccount;
    @ManyToOne
    @JoinColumn(name = "idBusnessUnit")
    private BusnessUnit busnessUnit;
    @OneToMany(mappedBy = "account",
            cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Project> projects;
}
