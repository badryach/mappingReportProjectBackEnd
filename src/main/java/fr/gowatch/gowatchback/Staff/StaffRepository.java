package fr.gowatch.gowatchback.Staff;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Long> {

    public Staff findByUserName(String username);
    public Staff findByIris(String iris);
}
