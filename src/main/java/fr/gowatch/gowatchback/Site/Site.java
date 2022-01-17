package fr.gowatch.gowatchback.Site;

import fr.gowatch.gowatchback.Account.Account;
import fr.gowatch.gowatchback.BusinessUnit.BusnessUnit;
import fr.gowatch.gowatchback.City.City;
import fr.gowatch.gowatchback.Country.Country;
import fr.gowatch.gowatchback.Roles.AppRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Site {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idSite;
    private String nameSite;
    @ManyToOne
    @JoinColumn(name = "idCity")
    private City city;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<BusnessUnit> busnessUnits= new ArrayList<>();
}
