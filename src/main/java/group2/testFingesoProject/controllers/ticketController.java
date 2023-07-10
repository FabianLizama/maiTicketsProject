package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.ticketEntity;
import group2.testFingesoProject.services.ticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ticketController {
    @Autowired
    ticketService ticketServiceInstance;
    @PostMapping(value = "/ticket/")
    public ResponseEntity<ticketEntity> save(@RequestBody ticketEntity newTicketEntity){
        ticketEntity object = ticketServiceInstance.createTicket(newTicketEntity);
        return new ResponseEntity<ticketEntity>(object, HttpStatus.OK);
    }

}
