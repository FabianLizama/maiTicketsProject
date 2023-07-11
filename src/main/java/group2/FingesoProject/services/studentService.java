package group2.FingesoProject.services;

import group2.FingesoProject.entitites.studentEntity;
import group2.FingesoProject.repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentService {
    @Autowired
    studentRepository studentRepositoryInstance;
    public studentEntity createStudent(studentEntity newStudent) {
        //student validation
        return studentRepositoryInstance.save(newStudent);
    }
}
