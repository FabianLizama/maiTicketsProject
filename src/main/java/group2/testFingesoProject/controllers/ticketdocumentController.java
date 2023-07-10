package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.ticketdocumentEntity;
import group2.testFingesoProject.services.ticketdocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ticketdocumentController {
    @Autowired
    ticketdocumentService ticketdocumentServiceInstance;
    @PostMapping(value = "/ticketdocument/")
    public ResponseEntity<ticketdocumentEntity> save(@RequestBody ticketdocumentEntity newTicketdocumentEntity){
        ticketdocumentEntity object = ticketdocumentServiceInstance.createTicketdocument(newTicketdocumentEntity);
        return new ResponseEntity<ticketdocumentEntity>(object, HttpStatus.OK);
    }

}
