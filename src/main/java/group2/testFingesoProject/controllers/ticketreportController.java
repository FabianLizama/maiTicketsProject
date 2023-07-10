package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.ticketreportEntity;
import group2.testFingesoProject.services.ticketreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ticketreportController {
    @Autowired
    ticketreportService ticketreportServiceInstance;
    @PostMapping(value = "/ticketreport/")
    public ResponseEntity<ticketreportEntity> save(@RequestBody ticketreportEntity newTicketreportEntity){
        ticketreportEntity object = ticketreportServiceInstance.createTicketreport(newTicketreportEntity);
        return new ResponseEntity<ticketreportEntity>(object, HttpStatus.OK);
    }

}
