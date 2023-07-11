package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.tickethistoryEntity;
import group2.FingesoProject.services.tickethistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickethistory")
public class tickethistoryController {
    @Autowired
    private final tickethistoryService tickethistoryServiceInstance;

    public tickethistoryController(tickethistoryService tickethistoryService){
        this.tickethistoryServiceInstance = tickethistoryService;
    }

    //CREATE
    @PostMapping
    public tickethistoryEntity createTickethistory(@RequestBody tickethistoryEntity tickethistory){
        return tickethistoryServiceInstance.createTickethistory(tickethistory);
    }

    //READ(ALL)
    @GetMapping
    public List<tickethistoryEntity> getAllTickethistorys(){
        return tickethistoryServiceInstance.getAllTickethistorys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<tickethistoryEntity> getTickethistoryByID(@PathVariable Long ID){
        Optional<tickethistoryEntity> tickethistory = tickethistoryServiceInstance.getTickethistoryById(ID);
        return tickethistory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public tickethistoryEntity updatetickethistory(@PathVariable Long ID, @RequestBody tickethistoryEntity tickethistory){
        tickethistory.setId_tickethistory(ID);
        return tickethistoryServiceInstance.updateTickethistory(tickethistory);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deletetickethistory(@PathVariable Long ID){
        tickethistoryServiceInstance.deleteTickethistory(ID);
        return ResponseEntity.noContent().build();
    }
}
