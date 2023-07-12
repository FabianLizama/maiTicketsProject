package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketPriorityEntity;
import group2.FingesoProject.services.ticketPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticketpriority")
public class ticketPriorityController {
    @Autowired
    private final ticketPriorityService ticketpriorityServiceInstance;

    public ticketPriorityController(ticketPriorityService ticketpriorityService){
        this.ticketpriorityServiceInstance = ticketpriorityService;
    }

    //CREATE
    @PostMapping
    public ticketPriorityEntity createTicketpriority(@RequestBody ticketPriorityEntity ticketpriority){
        return ticketpriorityServiceInstance.createTicketpriority(ticketpriority);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketPriorityEntity> getAllTicketprioritys(){
        return ticketpriorityServiceInstance.getAllTicketprioritys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketPriorityEntity> getTicketpriorityByID(@PathVariable Long ID){
        Optional<ticketPriorityEntity> ticketpriority = ticketpriorityServiceInstance.getTicketpriorityById(ID);
        return ticketpriority.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketPriorityEntity updateTicketpriority(@PathVariable Long ID, @RequestBody ticketPriorityEntity ticketpriority){
        ticketpriority.setId_ticketpriority(ID);
        return ticketpriorityServiceInstance.updateTicketpriority(ticketpriority);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketpriority(@PathVariable Long ID){
        ticketpriorityServiceInstance.deleteTicketpriority(ID);
        return ResponseEntity.noContent().build();
    }
}
