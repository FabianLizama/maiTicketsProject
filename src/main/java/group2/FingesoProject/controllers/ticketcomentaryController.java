package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketcomentaryEntity;
import group2.FingesoProject.services.ticketcomentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticketcomentary")
public class ticketcomentaryController {
    @Autowired
    private final ticketcomentaryService ticketcomentaryServiceInstance;

    public ticketcomentaryController(ticketcomentaryService ticketcomentaryService){
        this.ticketcomentaryServiceInstance = ticketcomentaryService;
    }

    //CREATE
    @PostMapping
    public ticketcomentaryEntity createTicketcomentary(@RequestBody ticketcomentaryEntity ticketcomentary){
        return ticketcomentaryServiceInstance.createTicketcomentary(ticketcomentary);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketcomentaryEntity> getAllTicketcomentarys(){
        return ticketcomentaryServiceInstance.getAllTicketcomentarys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketcomentaryEntity> getTicketcomentaryByID(@PathVariable Long ID){
        Optional<ticketcomentaryEntity> ticketcomentary = ticketcomentaryServiceInstance.getTicketcomentaryById(ID);
        return ticketcomentary.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketcomentaryEntity updateTicketcomentary(@PathVariable Long ID, @RequestBody ticketcomentaryEntity ticketcomentary){
        ticketcomentary.setId_ticketcomentary(ID);
        return ticketcomentaryServiceInstance.updateTicketcomentary(ticketcomentary);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketcomentary(@PathVariable Long ID){
        ticketcomentaryServiceInstance.deleteTicketcomentary(ID);
        return ResponseEntity.noContent().build();
    }
}
