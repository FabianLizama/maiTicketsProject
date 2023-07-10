package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.ticketratingEntity;
import group2.testFingesoProject.services.ticketratingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ticketratingController {
    @Autowired
    ticketratingService ticketratingServiceInstance;
    @PostMapping(value = "/ticketrating/")
    public ResponseEntity<ticketratingEntity> save(@RequestBody ticketratingEntity newTicketratingEntity){
        ticketratingEntity object = ticketratingServiceInstance.createTicketrating(newTicketratingEntity);
        return new ResponseEntity<ticketratingEntity>(object, HttpStatus.OK);
    }

}
