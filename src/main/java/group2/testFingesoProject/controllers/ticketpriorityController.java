package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.ticketpriorityEntity;
import group2.testFingesoProject.services.ticketpriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ticketpriorityController {
    @Autowired
    ticketpriorityService ticketpriorityServiceInstance;
    @PostMapping(value = "/ticketpriority/")
    public ResponseEntity<ticketpriorityEntity> save(@RequestBody ticketpriorityEntity newTicketpriorityEntity){
        ticketpriorityEntity object = ticketpriorityServiceInstance.createTicketpriority(newTicketpriorityEntity);
        return new ResponseEntity<ticketpriorityEntity>(object, HttpStatus.OK);
    }

}
