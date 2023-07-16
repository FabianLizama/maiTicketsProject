package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yoandroide.persona.entities.AcademicUnit;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.services.TicketService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tickets/")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    private ResponseEntity<List<Ticket>> getAllTickets(){
        return ResponseEntity.ok(ticketService.findAll());
    }

    @PostMapping
    private ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket){
        try{
            Ticket savedTicket = ticketService.save(ticket);
            return ResponseEntity.created(new URI("/tickets/"+savedTicket.getIdTicket())).body(savedTicket);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{idTicket}/units/{idAcademicUnit}")
    public AcademicUnit assignTicketToAcademicUnit (
            @PathVariable Long idAcademicUnit,
            @PathVariable Long idTicket) {
        return ticketService.assignTicketToAcademicUnit(idAcademicUnit, idTicket);
    }
}
