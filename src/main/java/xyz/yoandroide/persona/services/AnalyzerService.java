package xyz.yoandroide.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yoandroide.persona.entities.Analyzer;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.repositories.AnalyzerRepository;
import xyz.yoandroide.persona.repositories.ClientRepository;
import xyz.yoandroide.persona.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnalyzerService {
    @Autowired
    private AnalyzerRepository analyzerRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public <S extends Analyzer> S save(S entity) {
        return analyzerRepository.save(entity);
    }

    public Optional<Analyzer> findById(Long aLong) {
        return analyzerRepository.findById(aLong);
    }

    public List<Analyzer> findAll() {
        return analyzerRepository.findAll();
    }

    public long count() {
        return analyzerRepository.count();
    }

    public Client answerTicketToClient(Long idClient, Long idTicket, String answer) {
        List<Ticket> ticketList = null;
        Client client = clientRepository.findById(idClient).get();
        Ticket ticket = ticketRepository.findById(idTicket).get();
        ticket.setState("Respondido");
        ticket.setAnswer(answer);
        ticketList = client.getTickets();
        ticketList.add(ticket);
        client.setTickets(ticketList);
        return clientRepository.save(client);
    }

}
