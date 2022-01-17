package fr.gowatch.gowatchback.Country;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.gowatch.gowatchback.City.City;
import fr.gowatch.gowatchback.PageReport.Page;
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
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCountry;
    private String nameCountry;

    @OneToMany(mappedBy = "country",
            cascade =CascadeType.ALL)
    @JsonIgnore
    private List<City> cities;


}
