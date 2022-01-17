package fr.gowatch.gowatchback.City;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.gowatch.gowatchback.Country.Country;
import fr.gowatch.gowatchback.PageReport.Page;
import fr.gowatch.gowatchback.Site.Site;
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
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idAccount;
    private String nameAccount;
    @ManyToOne
    @JoinColumn(name = "idCountry")
    private Country country;
    @OneToMany(mappedBy = "city",
            cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Site> sites;
}
