package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.ticketComentaryEntity;
import group2.FingesoProject.services.ticketComentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TicketComentary")
public class ticketComentaryController {
    @Autowired
    private final ticketComentaryService ticketComentaryServiceInstance;

    public ticketComentaryController(ticketComentaryService ticketComentaryService){
        this.ticketComentaryServiceInstance = ticketComentaryService;
    }

    //CREATE
    @PostMapping
    public ticketComentaryEntity createTicketComentary(@RequestBody ticketComentaryEntity ticketComentary){
        return ticketComentaryServiceInstance.createTicketComentary(ticketComentary);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketComentaryEntity> getAllTicketComentarys(){
        return ticketComentaryServiceInstance.getAllTicketComentarys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketComentaryEntity> getTicketComentaryByID(@PathVariable Long ID){
        Optional<ticketComentaryEntity> ticketComentary = ticketComentaryServiceInstance.getTicketComentaryById(ID);
        return ticketComentary.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketComentaryEntity updateTicketComentary(@PathVariable Long ID, @RequestBody ticketComentaryEntity ticketComentary){
        ticketComentary.setId_ticketComentary(ID);
        return ticketComentaryServiceInstance.updateTicketComentary(ticketComentary);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketComentary(@PathVariable Long ID){
        ticketComentaryServiceInstance.deleteTicketComentary(ID);
        return ResponseEntity.noContent().build();
    }
}
