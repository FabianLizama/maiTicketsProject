package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.ticketHistoryEntity;
import group2.FingesoProject.services.ticketHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TicketHistory")
public class ticketHistoryController {
    @Autowired
    private final ticketHistoryService ticketHistoryServiceInstance;

    public ticketHistoryController(ticketHistoryService ticketHistoryService){
        this.ticketHistoryServiceInstance = ticketHistoryService;
    }

    //CREATE
    @PostMapping
    public ticketHistoryEntity createTicketHistory(@RequestBody ticketHistoryEntity ticketHistory){
        return ticketHistoryServiceInstance.createTicketHistory(ticketHistory);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketHistoryEntity> getAllTicketHistorys(){
        return ticketHistoryServiceInstance.getAllTicketHistorys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketHistoryEntity> getTicketHistoryByID(@PathVariable Long ID){
        Optional<ticketHistoryEntity> ticketHistory = ticketHistoryServiceInstance.getTicketHistoryById(ID);
        return ticketHistory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketHistoryEntity updateTicketHistory(@PathVariable Long ID, @RequestBody ticketHistoryEntity ticketHistory){
        ticketHistory.setId_ticketHistory(ID);
        return ticketHistoryServiceInstance.updateTicketHistory(ticketHistory);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteticketHistory(@PathVariable Long ID){
        ticketHistoryServiceInstance.deleteTicketHistory(ID);
        return ResponseEntity.noContent().build();
    }
}
