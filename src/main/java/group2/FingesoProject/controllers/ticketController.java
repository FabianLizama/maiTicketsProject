package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketEntity;
import group2.FingesoProject.services.ticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticket")
public class ticketController {
    @Autowired
    private final ticketService ticketServiceInstance;

    public ticketController(ticketService ticketService){
        this.ticketServiceInstance = ticketService;
    }

    //CREATE
    @PostMapping
    public ticketEntity createTicket(@RequestBody ticketEntity ticket){
        return ticketServiceInstance.createTicket(ticket);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketEntity> getAllTickets(){
        return ticketServiceInstance.getAllTickets();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketEntity> getTicketByID(@PathVariable Long ID){
        Optional<ticketEntity> ticket = ticketServiceInstance.getTicketById(ID);
        return ticket.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketEntity updateTicket(@PathVariable Long ID, @RequestBody ticketEntity ticket){
        ticket.setIdTicket(ID);
        return ticketServiceInstance.updateTicket(ticket);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long ID){
        ticketServiceInstance.deleteTicket(ID);
        return ResponseEntity.noContent().build();
    }
}
