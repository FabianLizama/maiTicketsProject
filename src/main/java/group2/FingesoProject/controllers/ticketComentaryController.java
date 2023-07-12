package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketComentaryEntity;
import group2.FingesoProject.services.ticketComentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticketcomentary")
public class ticketComentaryController {
    @Autowired
    private final ticketComentaryService ticketcomentaryServiceInstance;

    public ticketComentaryController(ticketComentaryService ticketcomentaryService){
        this.ticketcomentaryServiceInstance = ticketcomentaryService;
    }

    //CREATE
    @PostMapping
    public ticketComentaryEntity createTicketcomentary(@RequestBody ticketComentaryEntity ticketcomentary){
        return ticketcomentaryServiceInstance.createTicketcomentary(ticketcomentary);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketComentaryEntity> getAllTicketcomentarys(){
        return ticketcomentaryServiceInstance.getAllTicketcomentarys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketComentaryEntity> getTicketcomentaryByID(@PathVariable Long ID){
        Optional<ticketComentaryEntity> ticketcomentary = ticketcomentaryServiceInstance.getTicketcomentaryById(ID);
        return ticketcomentary.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketComentaryEntity updateTicketcomentary(@PathVariable Long ID, @RequestBody ticketComentaryEntity ticketcomentary){
        ticketcomentary.setId_ticketcomentary(ID);
        return ticketcomentaryServiceInstance.updateTicketcomentary(ticketcomentary);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketcomentary(@PathVariable Long ID){
        ticketcomentaryServiceInstance.deleteTicketcomentary(ID);
        return ResponseEntity.noContent().build();
    }
}
