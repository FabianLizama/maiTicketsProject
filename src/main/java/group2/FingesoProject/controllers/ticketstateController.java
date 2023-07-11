package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketstateEntity;
import group2.FingesoProject.services.ticketstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticketstate")
public class ticketstateController {
    @Autowired
    private final ticketstateService ticketstateServiceInstance;

    public ticketstateController(ticketstateService ticketstateService){
        this.ticketstateServiceInstance = ticketstateService;
    }

    //CREATE
    @PostMapping
    public ticketstateEntity createTicketstate(@RequestBody ticketstateEntity ticketstate){
        return ticketstateServiceInstance.createTicketstate(ticketstate);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketstateEntity> getAllTicketstates(){
        return ticketstateServiceInstance.getAllTicketstates();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketstateEntity> getTicketstateByID(@PathVariable Long ID){
        Optional<ticketstateEntity> ticketstate = ticketstateServiceInstance.getTicketstateById(ID);
        return ticketstate.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketstateEntity updateTicketstate(@PathVariable Long ID, @RequestBody ticketstateEntity ticketstate){
        ticketstate.setId_ticketstate(ID);
        return ticketstateServiceInstance.updateTicketstate(ticketstate);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketstate(@PathVariable Long ID){
        ticketstateServiceInstance.deleteTicketstate(ID);
        return ResponseEntity.noContent().build();
    }
}
