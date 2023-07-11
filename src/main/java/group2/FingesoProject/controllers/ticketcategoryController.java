package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketcategoryEntity;
import group2.FingesoProject.services.ticketcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticketcategory")
public class ticketcategoryController {
    @Autowired
    private final ticketcategoryService ticketcategoryServiceInstance;

    public ticketcategoryController(ticketcategoryService ticketcategoryService){
        this.ticketcategoryServiceInstance = ticketcategoryService;
    }

    //CREATE
    @PostMapping
    public ticketcategoryEntity createTicketcategory(@RequestBody ticketcategoryEntity ticketcategory){
        return ticketcategoryServiceInstance.createTicketcategory(ticketcategory);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketcategoryEntity> getAllTicketcategorys(){
        return ticketcategoryServiceInstance.getAllTicketcategorys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketcategoryEntity> getTicketcategoryByID(@PathVariable Long ID){
        Optional<ticketcategoryEntity> ticketcategory = ticketcategoryServiceInstance.getTicketcategoryById(ID);
        return ticketcategory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketcategoryEntity updateTicketcategory(@PathVariable Long ID, @RequestBody ticketcategoryEntity ticketcategory){
        ticketcategory.setId_ticketcategory(ID);
        return ticketcategoryServiceInstance.updateTicketcategory(ticketcategory);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketcategory(@PathVariable Long ID){
        ticketcategoryServiceInstance.deleteTicketcategory(ID);
        return ResponseEntity.noContent().build();
    }
}
