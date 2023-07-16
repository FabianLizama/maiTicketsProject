package xyz.yoandroide.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.repositories.ClientRepository;
import xyz.yoandroide.persona.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public <S extends Client> S save(S entity) {
        return clientRepository.save(entity);
    }


    public Optional<Client> findById(Long aLong) {
        return clientRepository.findById(aLong);
    }

    public void delete(Long id) { clientRepository.deleteById(id); }

    public boolean existById(Long id) {return clientRepository.existsById(id); }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public long count() {
        return clientRepository.count();
    }

    //Cambiar estado del ticket a creado.
    public Client assignTicketToClient(Long idClient, Long idTicket) {
        List<Ticket> ticketList = null;
        Client client = clientRepository.findById(idClient).get();
        Ticket ticket = ticketRepository.findById(idTicket).get();
        ticketList = client.getTickets();
        ticketList.add(ticket);
        client.setTickets(ticketList);
        return clientRepository.save(client);
    }
}
