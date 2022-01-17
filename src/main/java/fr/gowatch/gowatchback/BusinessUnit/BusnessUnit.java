package fr.gowatch.gowatchback.BusinessUnit;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.gowatch.gowatchback.Account.Account;
import fr.gowatch.gowatchback.City.City;
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
public class BusnessUnit implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idBu;
    private String BuName;

    @OneToMany(mappedBy = "busnessUnit",
            cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Account> account;
}
