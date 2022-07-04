package fr.mapping.mappingprojectreport.Staff;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff getStaff(String username) {
        Staff staff = this.staffRepository.findByUserName(username);
        if (staff == null)
            throw new RuntimeException("Cette adresse n'existe pas dans nos bases. Merci de voir avec un administrateur");
        return staff;
    }

    public Staff getStaffInfo(String iris) {
        Staff staff = this.staffRepository.findByIris(iris);
        return staff;
    }

    public List<Staff> getUsers() {
        return this.staffRepository.findAll();
    }
}
