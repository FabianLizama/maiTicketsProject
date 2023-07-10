package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.ticketcategoryEntity;
import group2.testFingesoProject.services.ticketcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ticketcategoryController {
    @Autowired
    ticketcategoryService ticketcategoryServiceInstance;
    @PostMapping(value = "/ticketcategory/")
    public ResponseEntity<ticketcategoryEntity> save(@RequestBody ticketcategoryEntity newTicketcategoryEntity){
        ticketcategoryEntity object = ticketcategoryServiceInstance.createTicketcategory(newTicketcategoryEntity);
        return new ResponseEntity<ticketcategoryEntity>(object, HttpStatus.OK);
    }

}
