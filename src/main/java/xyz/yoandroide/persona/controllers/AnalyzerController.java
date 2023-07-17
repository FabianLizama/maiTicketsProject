package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yoandroide.persona.entities.Analyzer;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.services.AnalyzerService;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/analyzers/")
public class AnalyzerController {
    @Autowired
    private AnalyzerService analyzerService;

    @GetMapping
    private ResponseEntity<List<Analyzer>> getAllAnalyzers(){
        return ResponseEntity.ok(analyzerService.findAll());
    }

    @GetMapping("/{idAnalyzer}")
    private ResponseEntity<Optional<Analyzer>> getIdAnalyzer(@PathVariable Long idAnalyzer){
        return ResponseEntity.ok(analyzerService.findById(idAnalyzer));
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

    @GetMapping("/{idAnalyzer}/tickets")
    private ResponseEntity<List<Ticket>> getTicketsByAnalyzer(@PathVariable Long idAnalyzer){
        return ResponseEntity.ok(analyzerService.findTicketsByAnalyzer(idAnalyzer));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ("id") Long id) {
        analyzerService.delete(id);
        return ResponseEntity.ok(!analyzerService.existById(id));
    }
    @PutMapping("/clients/{idClient}/tickets/{idTicket}")
    public Client answerTicketToClient (
            String answer,
            @PathVariable Long idClient,
            @PathVariable Long idTicket) {
        return analyzerService.answerTicketToClient(idClient, idTicket, answer);
    }

}
