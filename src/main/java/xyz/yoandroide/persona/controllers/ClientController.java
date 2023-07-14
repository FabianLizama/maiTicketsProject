package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.services.ClientService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients/")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    private ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping
    private ResponseEntity<Client> saveClient(@RequestBody Client client){
        try{
            Client savedClient = clientService.save(client);
            return ResponseEntity.created(new URI("/clients/"+savedClient.getIdClient())).body(savedClient);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{idClient}/tickets/{idTicket}")
    public Client assignTicketToClient (
            @PathVariable Long idClient,
            @PathVariable Long idTicket) {
        return clientService.assignTicketToClient(idClient, idTicket);
    }
}
