package fr.gowatch.gowatchback.Roles;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    public  AppRole findByRoleName(String roleName);
}
