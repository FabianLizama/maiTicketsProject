package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.ticketstateEntity;
import group2.testFingesoProject.services.ticketstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ticketstateController {
    @Autowired
    ticketstateService ticketstateServiceInstance;
    @PostMapping(value = "/ticketstate/")
    public ResponseEntity<ticketstateEntity> save(@RequestBody ticketstateEntity newTicketstateEntity){
        ticketstateEntity object = ticketstateServiceInstance.createTicketstate(newTicketstateEntity);
        return new ResponseEntity<ticketstateEntity>(object, HttpStatus.OK);
    }

}
