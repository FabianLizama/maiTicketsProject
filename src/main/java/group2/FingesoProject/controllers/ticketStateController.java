package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketStateEntity;
import group2.FingesoProject.services.ticketStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticketstate")
public class ticketStateController {
    @Autowired
    private final ticketStateService ticketstateServiceInstance;

    public ticketStateController(ticketStateService ticketstateService){
        this.ticketstateServiceInstance = ticketstateService;
    }

    //CREATE
    @PostMapping
    public ticketStateEntity createTicketstate(@RequestBody ticketStateEntity ticketstate){
        return ticketstateServiceInstance.createTicketstate(ticketstate);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketStateEntity> getAllTicketstates(){
        return ticketstateServiceInstance.getAllTicketstates();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketStateEntity> getTicketstateByID(@PathVariable Long ID){
        Optional<ticketStateEntity> ticketstate = ticketstateServiceInstance.getTicketstateById(ID);
        return ticketstate.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketStateEntity updateTicketstate(@PathVariable Long ID, @RequestBody ticketStateEntity ticketstate){
        ticketstate.setId_ticketstate(ID);
        return ticketstateServiceInstance.updateTicketstate(ticketstate);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketstate(@PathVariable Long ID){
        ticketstateServiceInstance.deleteTicketstate(ID);
        return ResponseEntity.noContent().build();
    }
}
