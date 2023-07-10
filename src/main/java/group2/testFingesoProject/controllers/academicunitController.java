package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.academicunitEntity;
import group2.testFingesoProject.services.academicunitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class academicunitController {
    @Autowired
    academicunitService academicunitServiceInstance;
    @PostMapping(value = "/academicunit/")
    public ResponseEntity<academicunitEntity> save(@RequestBody academicunitEntity newAcademicunitEntity){
        academicunitEntity object = academicunitServiceInstance.createAcademicunit(newAcademicunitEntity);
        return new ResponseEntity<academicunitEntity>(object, HttpStatus.OK);
    }

}
