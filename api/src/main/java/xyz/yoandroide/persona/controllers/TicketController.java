package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yoandroide.persona.entities.AcademicUnit;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.services.ClientService;
import xyz.yoandroide.persona.services.TicketService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets/")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private ClientService clientService;

    @GetMapping
    private ResponseEntity<List<Ticket>> getAllTickets(){
        return ResponseEntity.ok(ticketService.findAll());
    }

    @GetMapping("/{idTicket}")
    private ResponseEntity<Optional<Ticket>> getIdTicket(@PathVariable Long idTicket){
        return ResponseEntity.ok(ticketService.findById(idTicket));
    }

    @PostMapping("/add-ticket/{idClient}/")
    private ResponseEntity<Ticket> saveTicket(@PathVariable Long idClient, @RequestBody Ticket ticket){
        try{
            ticket.setFkIdClient(idClient);
            Ticket savedTicket = ticketService.save(ticket);
            clientService.assignTicketToClient(idClient, savedTicket.getIdTicket());
            return ResponseEntity.created(new URI("/tickets/"+savedTicket.getIdTicket())).body(savedTicket);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ("id") Long id) {
        ticketService.delete(id);
        return ResponseEntity.ok(!ticketService.existById(id));
    }

    @PutMapping("/{idTicket}/units/{idAcademicUnit}")
    public AcademicUnit assignTicketToAcademicUnit (
            @PathVariable Long idAcademicUnit,
            @PathVariable Long idTicket) {
        return ticketService.assignTicketToAcademicUnit(idAcademicUnit, idTicket);
    }
}
