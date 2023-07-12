package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketDocumentEntity;
import group2.FingesoProject.services.ticketDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticketdocument")
public class ticketDocumentController {
    @Autowired
    private final ticketDocumentService ticketdocumentServiceInstance;

    public ticketDocumentController(ticketDocumentService ticketdocumentService){
        this.ticketdocumentServiceInstance = ticketdocumentService;
    }

    //CREATE
    @PostMapping
    public ticketDocumentEntity createTicketdocument(@RequestBody ticketDocumentEntity ticketdocument){
        return ticketdocumentServiceInstance.createTicketdocument(ticketdocument);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketDocumentEntity> getAllTicketdocuments(){
        return ticketdocumentServiceInstance.getAllTicketdocuments();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketDocumentEntity> getTicketdocumentByID(@PathVariable Long ID){
        Optional<ticketDocumentEntity> ticketdocument = ticketdocumentServiceInstance.getTicketdocumentById(ID);
        return ticketdocument.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketDocumentEntity updateTicketdocument(@PathVariable Long ID, @RequestBody ticketDocumentEntity ticketdocument){
        ticketdocument.setId_ticketdocument(ID);
        return ticketdocumentServiceInstance.updateTicketdocument(ticketdocument);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketdocument(@PathVariable Long ID){
        ticketdocumentServiceInstance.deleteTicketdocument(ID);
        return ResponseEntity.noContent().build();
    }
}
