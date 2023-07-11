package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.studentEntity;
import group2.FingesoProject.services.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentController {
    @Autowired
    studentService studentServiceInstance;
    @PostMapping(value = "/student/")
    public ResponseEntity<studentEntity> save(@RequestBody studentEntity newStudentEntity){
        studentEntity object = studentServiceInstance.createStudent(newStudentEntity);
        return new ResponseEntity<studentEntity>(object, HttpStatus.OK);
    }

}
