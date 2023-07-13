package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.ticketDocumentEntity;
import group2.FingesoProject.services.ticketDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TicketDocument")
public class ticketdDocumentController {
    @Autowired
    private final ticketDocumentService ticketDocumentServiceInstance;

    public ticketdDocumentController(ticketDocumentService ticketDocumentService){
        this.ticketDocumentServiceInstance = ticketDocumentService;
    }

    //CREATE
    @PostMapping
    public ticketDocumentEntity createTicketDocument(@RequestBody ticketDocumentEntity ticketDocument){
        return ticketDocumentServiceInstance.createTicketDocument(ticketDocument);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketDocumentEntity> getAllTicketDocuments(){
        return ticketDocumentServiceInstance.getAllTicketDocuments();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketDocumentEntity> getTicketDocumentByID(@PathVariable Long ID){
        Optional<ticketDocumentEntity> ticketDocument = ticketDocumentServiceInstance.getTicketDocumentById(ID);
        return ticketDocument.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketDocumentController updateTicketDocument(@PathVariable Long ID, @RequestBody ticketDocumentController ticketDocument){
        ticketDocument.setId_ticketDocument(ID);
        return ticketDocumentServiceInstance.updateTicketDocument(ticketDocument);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketDocument(@PathVariable Long ID){
        ticketDocumentServiceInstance.deleteTicketDocument(ID);
        return ResponseEntity.noContent().build();
    }
}
