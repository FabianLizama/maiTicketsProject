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

import java.util.ArrayList;
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

    public void delete(Long id) { leadershipRepository.deleteById(id); }

    public boolean existById(Long id) {return leadershipRepository.existsById(id); }


    public List<Leadership> findAll() {
        return leadershipRepository.findAll();
    }

    public List<Analyzer> findAnalyzersByLeadership(Long idLeadership){
        List<Leadership> leaderships = leadershipRepository.findAll();

        for(Leadership leadership : leaderships){
            if(leadership.getIdLeadership().equals(idLeadership)){
                return leadership.getAnalyzers();
            }
        }
        return null;
    }

    public List<Ticket> findTicketsByLeadership(Long idLeadership){
        List<Leadership> leaderships = leadershipRepository.findAll();

        for(Leadership leadership : leaderships){
            if(leadership.getIdLeadership().equals(idLeadership)){
                return leadership.getTickets();
            }
        }
        return null;
    }

    public List<Ticket> findUnassignedTicketsByLeadership(Long idLeadership){
        Optional<Leadership> leadership = leadershipRepository.findById(idLeadership);

        List<Ticket> tickets = leadership.get().getTickets();
        List<Ticket> unassigned = new ArrayList<>();
        for(Ticket ticket : tickets){
            if(ticket.getState().equals("Sin asignar")){
                unassigned.add(ticket);
            }
        }
        return unassigned;
    }

    public List<Ticket> findAnsweredTicketsByLeadership(Long idLeadership){
        Optional<Leadership> leadership = leadershipRepository.findById(idLeadership);

        List<Ticket> tickets = leadership.get().getTickets();
        List<Ticket> answered = new ArrayList<>();

        for(Ticket ticket : tickets){
            if(ticket.getState().equals("Respondido")){
                answered.add(ticket);
            }
        }
        return answered;
    }


    public long count() {
        return leadershipRepository.count();
    }

    public Analyzer assignTicketToAnalyzer(Long idAnalyzer, Long idTicket) {
        List<Ticket> ticketList = null;
        Analyzer analyzer = analyzerRepository.findById(idAnalyzer).get();
        Ticket ticket = ticketRepository.findById(idTicket).get();
        ticket.setState("Asignado");
        ticket.setFkIdAnalyzer(idAnalyzer);
        ticketList = analyzer.getTickets();
        ticketList.add(ticket);
        analyzer.setTickets(ticketList);
        return analyzerRepository.save(analyzer);
    }

    public Leadership findByEmail(String email){
        List<Leadership> leaderships = leadershipRepository.findAll();
        for(Leadership leadership : leaderships){
            String leadershipEmail = leadership.getEmail();
            if(leadershipEmail != null && leadershipEmail.equals(email)){
                return leadership;
            }
        }
        return null;
    }
}
