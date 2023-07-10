package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.internalclientEntity;
import group2.testFingesoProject.services.internalclientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class internalclientController {
    @Autowired
    internalclientService internalclientServiceInstance;
    @PostMapping(value = "/internalclient/")
    public ResponseEntity<internalclientEntity> save(@RequestBody internalclientEntity newInternalclientEntity){
        internalclientEntity object = internalclientServiceInstance.createInternalclient(newInternalclientEntity);
        return new ResponseEntity<internalclientEntity>(object, HttpStatus.OK);
    }

}
