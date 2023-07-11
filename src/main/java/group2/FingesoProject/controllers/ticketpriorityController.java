package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketpriorityEntity;
import group2.FingesoProject.services.ticketpriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticketpriority")
public class ticketpriorityController {
    @Autowired
    private final ticketpriorityService ticketpriorityServiceInstance;

    public ticketpriorityController(ticketpriorityService ticketpriorityService){
        this.ticketpriorityServiceInstance = ticketpriorityService;
    }

    //CREATE
    @PostMapping
    public ticketpriorityEntity createTicketpriority(@RequestBody ticketpriorityEntity ticketpriority){
        return ticketpriorityServiceInstance.createTicketpriority(ticketpriority);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketpriorityEntity> getAllTicketprioritys(){
        return ticketpriorityServiceInstance.getAllTicketprioritys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketpriorityEntity> getTicketpriorityByID(@PathVariable Long ID){
        Optional<ticketpriorityEntity> ticketpriority = ticketpriorityServiceInstance.getTicketpriorityById(ID);
        return ticketpriority.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketpriorityEntity updateTicketpriority(@PathVariable Long ID, @RequestBody ticketpriorityEntity ticketpriority){
        ticketpriority.setId_ticketpriority(ID);
        return ticketpriorityServiceInstance.updateTicketpriority(ticketpriority);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketpriority(@PathVariable Long ID){
        ticketpriorityServiceInstance.deleteTicketpriority(ID);
        return ResponseEntity.noContent().build();
    }
}
