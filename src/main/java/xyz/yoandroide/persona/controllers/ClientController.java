package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.services.ClientService;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/clients/")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    private ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{idClient}")
    private ResponseEntity<Optional<Client>> getIdClient(@PathVariable Long idClient){
        return ResponseEntity.ok(clientService.findById(idClient));
    }

    @GetMapping("/{idClient}/tickets")
    private ResponseEntity<List<Ticket>> getTicketsByClient(@PathVariable Long idClient){
        return ResponseEntity.ok(clientService.findTicketsByClient(idClient));
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

    @PostMapping("/login/")
    private ResponseEntity<Long> loginClient(@RequestBody Client client) {
        try{
            String email = (String) client.getEmail();
            String password = (String) client.getPassword();
            //return ResponseEntity.accepted(clientService.existLogin(email, password));
            return ResponseEntity.ok(clientService.existLogin(email, password));
            //return ResponseEntity.created(new URI("/clients/"+savedClient.getIdClient())).body(savedClient);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ("id") Long id) {
        clientService.delete(id);
        return ResponseEntity.ok(!clientService.existById(id));
    }

    @PutMapping("/{idClient}/tickets/{idTicket}")
    public Client assignTicketToClient (
            @PathVariable Long idClient,
            @PathVariable Long idTicket) {
        return clientService.assignTicketToClient(idClient, idTicket);
    }

}
