package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketCategoryEntity;
import group2.FingesoProject.services.ticketCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticketcategory")
public class ticketCategoryController {
    @Autowired
    private final ticketCategoryService ticketcategoryServiceInstance;

    public ticketCategoryController(ticketCategoryService ticketcategoryService){
        this.ticketcategoryServiceInstance = ticketcategoryService;
    }

    //CREATE
    @PostMapping
    public ticketCategoryEntity createTicketcategory(@RequestBody ticketCategoryEntity ticketcategory){
        return ticketcategoryServiceInstance.createTicketcategory(ticketcategory);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketCategoryEntity> getAllTicketcategorys(){
        return ticketcategoryServiceInstance.getAllTicketcategorys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketCategoryEntity> getTicketcategoryByID(@PathVariable Long ID){
        Optional<ticketCategoryEntity> ticketcategory = ticketcategoryServiceInstance.getTicketcategoryById(ID);
        return ticketcategory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketCategoryEntity updateTicketcategory(@PathVariable Long ID, @RequestBody ticketCategoryEntity ticketcategory){
        ticketcategory.setId_ticketcategory(ID);
        return ticketcategoryServiceInstance.updateTicketcategory(ticketcategory);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketcategory(@PathVariable Long ID){
        ticketcategoryServiceInstance.deleteTicketcategory(ID);
        return ResponseEntity.noContent().build();
    }
}
