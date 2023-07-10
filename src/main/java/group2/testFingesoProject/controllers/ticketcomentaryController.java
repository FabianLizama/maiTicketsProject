package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.ticketcomentaryEntity;
import group2.testFingesoProject.services.ticketcomentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ticketcomentaryController {
    @Autowired
    ticketcomentaryService ticketcomentaryServiceInstance;
    @PostMapping(value = "/ticketcomentary/")
    public ResponseEntity<ticketcomentaryEntity> save(@RequestBody ticketcomentaryEntity newTicketcomentaryEntity){
        ticketcomentaryEntity object = ticketcomentaryServiceInstance.createTicketcomentary(newTicketcomentaryEntity);
        return new ResponseEntity<ticketcomentaryEntity>(object, HttpStatus.OK);
    }

}
