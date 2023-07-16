package xyz.yoandroide.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yoandroide.persona.entities.Analyzer;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.entities.Leadership;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.repositories.AnalyzerRepository;
import xyz.yoandroide.persona.repositories.LeadershipRepository;
import xyz.yoandroide.persona.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LeadershipService {
    @Autowired
    private LeadershipRepository leadershipRepository;

    @Autowired
    private AnalyzerRepository analyzerRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public <S extends Leadership> S save(S entity) {
        return leadershipRepository.save(entity);
    }


    public Optional<Leadership> findById(Long aLong) {
        return leadershipRepository.findById(aLong);
    }


    public List<Leadership> findAll() {
        return leadershipRepository.findAll();
    }


    public long count() {
        return leadershipRepository.count();
    }

    //Cambiar estado del ticket asignado.
    public Analyzer assignTicketToAnalyzer(Long idAnalyzer, Long idTicket) {
        List<Ticket> ticketList = null;
        Analyzer analyzer = analyzerRepository.findById(idAnalyzer).get();
        Ticket ticket = ticketRepository.findById(idTicket).get();
        ticket.setState("Asignado");
        ticketList = analyzer.getTickets();
        ticketList.add(ticket);
        analyzer.setTickets(ticketList);
        return analyzerRepository.save(analyzer);
    }
}
