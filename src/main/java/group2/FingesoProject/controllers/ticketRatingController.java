package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.ticketRatingEntity;
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
    private final ticketRatingService ticketRatingServiceInstance;

    public ticketRatingController(ticketRatingService ticketRatingService){
        this.ticketRatingServiceInstance = ticketRatingService;
    }

    //CREATE
    @PostMapping
    public ticketRatingEntity createTicketrating(@RequestBody ticketRatingEntity ticketRating){
        return ticketRatingServiceInstance.createTicketrating(ticketRating);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketRatingEntity> getAllTicketratings(){
        return ticketRatingServiceInstance.getAllTicketratings();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketRatingEntity> getTicketratingByID(@PathVariable Long ID){
        Optional<ticketRatingEntity> ticketRating = ticketRatingServiceInstance.getTicketratingById(ID);
        return ticketRating.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketRatingEntity updateTicketrating(@PathVariable Long ID, @RequestBody ticketRatingEntity ticketRating){
        ticketRating.setId_ticketRating(ID);
        return ticketRatingServiceInstance.updateTicketrating(ticketRating);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketrating(@PathVariable Long ID){
        ticketRatingServiceInstance.deleteTicketrating(ID);
        return ResponseEntity.noContent().build();
    }
}
