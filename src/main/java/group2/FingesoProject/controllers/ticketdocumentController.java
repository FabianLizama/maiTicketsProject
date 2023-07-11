package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketdocumentEntity;
import group2.FingesoProject.services.ticketdocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticketdocument")
public class ticketdocumentController {
    @Autowired
    private final ticketdocumentService ticketdocumentServiceInstance;

    public ticketdocumentController(ticketdocumentService ticketdocumentService){
        this.ticketdocumentServiceInstance = ticketdocumentService;
    }

    //CREATE
    @PostMapping
    public ticketdocumentEntity createTicketdocument(@RequestBody ticketdocumentEntity ticketdocument){
        return ticketdocumentServiceInstance.createTicketdocument(ticketdocument);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketdocumentEntity> getAllTicketdocuments(){
        return ticketdocumentServiceInstance.getAllTicketdocuments();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketdocumentEntity> getTicketdocumentByID(@PathVariable Long ID){
        Optional<ticketdocumentEntity> ticketdocument = ticketdocumentServiceInstance.getTicketdocumentById(ID);
        return ticketdocument.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketdocumentEntity updateTicketdocument(@PathVariable Long ID, @RequestBody ticketdocumentEntity ticketdocument){
        ticketdocument.setId_ticketdocument(ID);
        return ticketdocumentServiceInstance.updateTicketdocument(ticketdocument);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketdocument(@PathVariable Long ID){
        ticketdocumentServiceInstance.deleteTicketdocument(ID);
        return ResponseEntity.noContent().build();
    }
}
