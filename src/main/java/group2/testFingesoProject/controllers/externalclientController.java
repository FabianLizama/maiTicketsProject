package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.externalclientEntity;
import group2.testFingesoProject.services.externalclientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class externalclientController {
    @Autowired
    externalclientService externalclientServiceInstance;
    @PostMapping(value = "/externalclient/")
    public ResponseEntity<externalclientEntity> save(@RequestBody externalclientEntity newExternalclientEntity){
        externalclientEntity object = externalclientServiceInstance.createExternalclient(newExternalclientEntity);
        return new ResponseEntity<externalclientEntity>(object, HttpStatus.OK);
    }

}
