package fr.gowatch.gowatchback.Staff;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
   public AppUser findByUsername(String username);
   public AppUser findByIris(Staff id);
}
