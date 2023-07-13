package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.ticketPriorityEntity;
import group2.FingesoProject.services.ticketPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TicketPriority")
public class ticketPriorityController {
    @Autowired
    private final ticketPriorityService ticketPriorityServiceInstance;

    public ticketPriorityController(ticketPriorityService ticketPriorityService){
        this.ticketPriorityServiceInstance = ticketPriorityService;
    }

    //CREATE
    @PostMapping
    public ticketPriorityEntity createTicketPriority(@RequestBody ticketPriorityEntity ticketPriority){
        return ticketPriorityServiceInstance.createTicketPriority(ticketPriority);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketPriorityEntity> getAllTicketPrioritys(){
        return ticketPriorityServiceInstance.getAllTicketPrioritys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketPriorityEntity> getTicketPriorityByID(@PathVariable Long ID){
        Optional<ticketPriorityEntity> ticketPriority = ticketPriorityServiceInstance.getTicketPriorityById(ID);
        return ticketPriority.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketPriorityEntity updateTicketPriority(@PathVariable Long ID, @RequestBody ticketPriorityEntity ticketPriority){
        ticketPriority.setId_ticketPriority(ID);
        return ticketPriorityServiceInstance.updateTicketPriority(ticketPriority);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketPriority(@PathVariable Long ID){
        ticketPriorityServiceInstance.deleteTicketPriority(ID);
        return ResponseEntity.noContent().build();
    }
}
