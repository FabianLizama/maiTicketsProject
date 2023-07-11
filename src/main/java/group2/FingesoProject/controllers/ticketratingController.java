package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketratingEntity;
import group2.FingesoProject.services.ticketratingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticketrating")
public class ticketratingController {
    @Autowired
    private final ticketratingService ticketratingServiceInstance;

    public ticketratingController(ticketratingService ticketratingService){
        this.ticketratingServiceInstance = ticketratingService;
    }

    //CREATE
    @PostMapping
    public ticketratingEntity createTicketrating(@RequestBody ticketratingEntity ticketrating){
        return ticketratingServiceInstance.createTicketrating(ticketrating);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketratingEntity> getAllTicketratings(){
        return ticketratingServiceInstance.getAllTicketratings();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketratingEntity> getTicketratingByID(@PathVariable Long ID){
        Optional<ticketratingEntity> ticketrating = ticketratingServiceInstance.getTicketratingById(ID);
        return ticketrating.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketratingEntity updateTicketrating(@PathVariable Long ID, @RequestBody ticketratingEntity ticketrating){
        ticketrating.setId_ticketrating(ID);
        return ticketratingServiceInstance.updateTicketrating(ticketrating);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketrating(@PathVariable Long ID){
        ticketratingServiceInstance.deleteTicketrating(ID);
        return ResponseEntity.noContent().build();
    }
}
