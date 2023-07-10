package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.tickethistoryEntity;
import group2.testFingesoProject.services.tickethistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tickethistoryController {
    @Autowired
    tickethistoryService tickethistoryServiceInstance;
    @PostMapping(value = "/tickethistory/")
    public ResponseEntity<tickethistoryEntity> save(@RequestBody tickethistoryEntity newTickethistoryEntity){
        tickethistoryEntity object = tickethistoryServiceInstance.createTickethistory(newTickethistoryEntity);
        return new ResponseEntity<tickethistoryEntity>(object, HttpStatus.OK);
    }

}
