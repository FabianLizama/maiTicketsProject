package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketRatingEntity;
import group2.FingesoProject.services.ticketRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticketrating")
public class ticketRatingController {
    @Autowired
    private final ticketRatingService ticketratingServiceInstance;

    public ticketRatingController(ticketRatingService ticketratingService){
        this.ticketratingServiceInstance = ticketratingService;
    }

    //CREATE
    @PostMapping
    public ticketRatingEntity createTicketrating(@RequestBody ticketRatingEntity ticketrating){
        return ticketratingServiceInstance.createTicketrating(ticketrating);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketRatingEntity> getAllTicketratings(){
        return ticketratingServiceInstance.getAllTicketratings();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketRatingEntity> getTicketratingByID(@PathVariable Long ID){
        Optional<ticketRatingEntity> ticketrating = ticketratingServiceInstance.getTicketratingById(ID);
        return ticketrating.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketRatingEntity updateTicketrating(@PathVariable Long ID, @RequestBody ticketRatingEntity ticketrating){
        ticketrating.setId_ticketrating(ID);
        return ticketratingServiceInstance.updateTicketrating(ticketrating);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketrating(@PathVariable Long ID){
        ticketratingServiceInstance.deleteTicketrating(ID);
        return ResponseEntity.noContent().build();
    }
}
