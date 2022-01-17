package fr.gowatch.gowatchback.MappingStaffProject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MappinStaffProjectId implements Serializable {
    private Long project;
    private String staff;

}
