package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yoandroide.persona.entities.Analyzer;
import xyz.yoandroide.persona.entities.Leadership;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.services.LeadershipService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/leaderships/")
public class LeadershipController {
    @Autowired
    private LeadershipService leadershipService;

    @GetMapping
    private ResponseEntity<List<Leadership>> getAllLeaderships(){
        return ResponseEntity.ok(leadershipService.findAll());
    }

    @PostMapping
    private ResponseEntity<Leadership> saveLeadership(@RequestBody Leadership leadership){
        try{
            Leadership savedLeadership = leadershipService.save(leadership);
            return ResponseEntity.created(new URI("/leaderships/"+savedLeadership.getIdLeadership())).body(savedLeadership);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{idAnalyzer}/ticket/{idTicket}")
    public Analyzer assignTicketToAnalyzer(
            @PathVariable Long idAnalyzer,
            @PathVariable Long idTicket) {
        return leadershipService.assignTicketToAnalyzer(idAnalyzer, idTicket);
    }
}