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
import java.util.Optional;

@RestController
@RequestMapping("/leaderships/")
public class LeadershipController {
    @Autowired
    private LeadershipService leadershipService;

    @GetMapping
    private ResponseEntity<List<Leadership>> getAllLeaderships(){
        return ResponseEntity.ok(leadershipService.findAll());
    }

    @GetMapping("/{idLeadership}")
    private ResponseEntity<Optional<Leadership>> getIdLeadership(@PathVariable Long idLeadership){
        return ResponseEntity.ok(leadershipService.findById(idLeadership));
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ("id") Long id) {
        leadershipService.delete(id);
        return ResponseEntity.ok(!leadershipService.existById(id));
    }

    @PutMapping("/analyzers/{idAnalyzer}/tickets/{idTicket}")
    public Analyzer assignTicketToAnalyzer(
            @PathVariable Long idAnalyzer,
            @PathVariable Long idTicket) {
        return leadershipService.assignTicketToAnalyzer(idAnalyzer, idTicket);
    }

    @GetMapping("/{idLeadership}/analyzers")
    public ResponseEntity<List<Analyzer>> getAnalyzersByLeadership(@PathVariable String idLeadership){
        Long idLeader = Long.parseLong(idLeadership);
        return ResponseEntity.ok(leadershipService.findAnalyzersByLeadership(idLeader));
    }

    @GetMapping("/{idLeadership}/tickets")
    public ResponseEntity<List<Ticket>> getTicketsByLeadership(@PathVariable String idLeadership){
        Long idLeader = Long.parseLong(idLeadership);
        return ResponseEntity.ok(leadershipService.findTicketsByLeadership(idLeader));
    }

    @GetMapping("/{idLeadership}/tickets-sin-asignar")
    public ResponseEntity<List<Ticket>> getUnasignedTicketsByLeadership(@PathVariable String idLeadership){
        Long idLeader = Long.parseLong(idLeadership);
        return ResponseEntity.ok(leadershipService.findUnassignedTicketsByLeadership(idLeader));
    }

    @GetMapping("/{idLeadership}/tickets-por-validar")
    public ResponseEntity<List<Ticket>> getAnsweredTicketsByLeadership(@PathVariable String idLeadership){
        Long idLeader = Long.parseLong(idLeadership);
        return ResponseEntity.ok(leadershipService.findAnsweredTicketsByLeadership(idLeader));
    }
}
