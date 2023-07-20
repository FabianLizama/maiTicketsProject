package xyz.yoandroide.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yoandroide.persona.entities.Analyzer;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.entities.Leadership;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.repositories.AnalyzerRepository;
import xyz.yoandroide.persona.repositories.ClientRepository;
import xyz.yoandroide.persona.repositories.LeadershipRepository;
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

    @Autowired
    private LeadershipRepository leadershipRepository;

    public <S extends Analyzer> S save(S entity) {
        return analyzerRepository.save(entity);
    }

    public Optional<Analyzer> findById(Long aLong) {
        return analyzerRepository.findById(aLong);
    }

    public void delete(Long id) { analyzerRepository.deleteById(id); }

    public boolean existById(Long id) {return analyzerRepository.existsById(id); }

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

    public List<Ticket> findTicketsByAnalyzer(Long idAnalyzer){
        List<Leadership> leaderships = leadershipRepository.findAll();
        for(Leadership leadership : leaderships){
            List<Analyzer> analyzers = leadership.getAnalyzers();
            for(Analyzer analyzer : analyzers){
                if(analyzer.getIdAnalyzer().equals(idAnalyzer)){
                    return analyzer.getTickets();
                }
            }
        }
        return null;
    }

    public Analyzer findByEmail(String email){
        List<Analyzer> analyzers = analyzerRepository.findAll();
        for(Analyzer analyzer : analyzers){
            String analyzerEmail = analyzer.getEmail();
            if(analyzerEmail != null && analyzerEmail.equals(email)){
                return analyzer;
            }
        }
        return null;
    }

}
