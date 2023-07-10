package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.academicunitEntity;
import group2.testFingesoProject.repositories.academicunitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class academicunitService {
    @Autowired
    academicunitRepository academicunitRepositoryInstance;
    public academicunitEntity createAcademicunit(academicunitEntity newAcademicunit) {
        //student validation
        return academicunitRepositoryInstance.save(newAcademicunit);
    }
}
