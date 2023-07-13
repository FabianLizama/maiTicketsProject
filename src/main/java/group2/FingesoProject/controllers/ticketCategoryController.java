package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.ticketCategoryEntity;
import group2.FingesoProject.services.ticketCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TicketCategory")
public class ticketCategoryController {
    @Autowired
    private final ticketCategoryService ticketCategoryServiceInstance;

    public ticketCategoryController(ticketCategoryService ticketCategoryService){
        this.ticketCategoryServiceInstance = ticketCategoryService;
    }

    //CREATE
    @PostMapping
    public ticketCategoryEntity createTicketCategory(@RequestBody ticketCategoryEntity ticketCategory){
        return ticketCategoryServiceInstance.createTicketCategory(ticketCategory);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketCategoryEntity> getAllTicketCategorys(){
        return ticketCategoryServiceInstance.getAllTicketCategorys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketCategoryEntity> getTicketCategoryByID(@PathVariable Long ID){
        Optional<ticketCategoryEntity> ticketCategory = ticketCategoryServiceInstance.getTicketCategoryById(ID);
        return ticketCategory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketCategoryEntity updateTicketCategory(@PathVariable Long ID, @RequestBody ticketCategoryEntity ticketCategory){
        ticketCategory.setId_ticketCategory(ID);
        return ticketCategoryServiceInstance.updateTicketCategory(ticketCategory);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketCategory(@PathVariable Long ID){
        ticketCategoryServiceInstance.deleteTicketCategory(ID);
        return ResponseEntity.noContent().build();
    }
}
