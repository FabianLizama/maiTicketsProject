package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yoandroide.persona.entities.Analyzer;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.services.AnalyzerService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/analyzers/")
public class AnalyzerController {
    @Autowired
    private AnalyzerService analyzerService;

    @GetMapping
    private ResponseEntity<List<Analyzer>> getAllAnalyzers(){
        return ResponseEntity.ok(analyzerService.findAll());
    }

    @PostMapping
    private ResponseEntity<Analyzer> saveAnalyzer(@RequestBody Analyzer analyzer){
        try{
            Analyzer savedAnalyzer = analyzerService.save(analyzer);
            return ResponseEntity.created(new URI("/analyzers/"+savedAnalyzer.getIdAnalyzer())).body(savedAnalyzer);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/clients/{idClient}/tickets/{idTicket}")
    public Client answerTicketToClient (
            String answer,
            @PathVariable Long idClient,
            @PathVariable Long idTicket) {
        return analyzerService.answerTicketToClient(idClient, idTicket, answer);
    }

}
