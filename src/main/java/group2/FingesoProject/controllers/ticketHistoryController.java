package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketHistoryEntity;
import group2.FingesoProject.services.ticketHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Tickethistory")
public class ticketHistoryController {
    @Autowired
    private final ticketHistoryService tickethistoryServiceInstance;

    public ticketHistoryController(ticketHistoryService tickethistoryService){
        this.tickethistoryServiceInstance = tickethistoryService;
    }

    //CREATE
    @PostMapping
    public ticketHistoryEntity createTickethistory(@RequestBody ticketHistoryEntity tickethistory){
        return tickethistoryServiceInstance.createTickethistory(tickethistory);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketHistoryEntity> getAllTickethistorys(){
        return tickethistoryServiceInstance.getAllTickethistorys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketHistoryEntity> getTickethistoryByID(@PathVariable Long ID){
        Optional<ticketHistoryEntity> tickethistory = tickethistoryServiceInstance.getTickethistoryById(ID);
        return tickethistory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketHistoryEntity updatetickethistory(@PathVariable Long ID, @RequestBody ticketHistoryEntity tickethistory){
        tickethistory.setId_tickethistory(ID);
        return tickethistoryServiceInstance.updateTickethistory(tickethistory);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deletetickethistory(@PathVariable Long ID){
        tickethistoryServiceInstance.deleteTickethistory(ID);
        return ResponseEntity.noContent().build();
    }
}
