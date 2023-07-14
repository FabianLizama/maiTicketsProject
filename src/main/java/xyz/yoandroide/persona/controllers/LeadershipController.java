package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yoandroide.persona.entities.Analyzer;
import xyz.yoandroide.persona.entities.Leadership;
import xyz.yoandroide.persona.services.LeadershipService;

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

    @PutMapping("/{idAnalyzer}/ticket/{idTicket}")
    public Analyzer assignTicketToAnalyzer(
            @PathVariable Long idAnalyzer,
            @PathVariable Long idTicket) {
        return leadershipService.assignTicketToAnalyzer(idAnalyzer, idTicket);
    }
}
