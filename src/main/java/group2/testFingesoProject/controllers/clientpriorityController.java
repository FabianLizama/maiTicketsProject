package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.clientpriorityEntity;
import group2.testFingesoProject.services.clientpriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clientpriorityController {
    @Autowired
    clientpriorityService clientpriorityServiceInstance;
    @PostMapping(value = "/clientpriority/")
    public ResponseEntity<clientpriorityEntity> save(@RequestBody clientpriorityEntity newClientpriorityEntity){
        clientpriorityEntity object = clientpriorityServiceInstance.createClientpriority(newClientpriorityEntity);
        return new ResponseEntity<clientpriorityEntity>(object, HttpStatus.OK);
    }

}
