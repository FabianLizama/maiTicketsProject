package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.ticketStateEntity;
import group2.FingesoProject.services.ticketStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TicketState")
public class ticketStateController {
    @Autowired
    private final ticketStateService ticketStateServiceInstance;

    public ticketStateController(ticketStateService ticketStateService){
        this.ticketStateServiceInstance = ticketStateService;
    }

    //CREATE
    @PostMapping
    public ticketStateEntity createTicketState(@RequestBody ticketStateEntity ticketState){
        return ticketStateServiceInstance.createTicketState(ticketState);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketStateEntity> getAllTicketStates(){
        return ticketstateServiceInstance.getAllTicketstates();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketStateEntity> getTicketStateByID(@PathVariable Long ID){
        Optional<ticketStateEntity> ticketState = ticketstateServiceInstance.getTicketStateById(ID);
        return ticketState.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketStateController updateTicketState(@PathVariable Long ID, @RequestBody ticketStateController ticketState){
        ticketState.setId_ticketState(ID);
        return ticketStateServiceInstance.updateTicketState(ticketState);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketState(@PathVariable Long ID){
        ticketStateServiceInstance.deleteTicketState(ID);
        return ResponseEntity.noContent().build();
    }
}
