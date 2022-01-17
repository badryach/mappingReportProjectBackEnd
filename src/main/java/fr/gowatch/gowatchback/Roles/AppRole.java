package fr.gowatch.gowatchback.Roles;


import lombok.*;

import javax.persistence.*;

@Entity
@Table

public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    public AppRole(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public AppRole() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }
}
