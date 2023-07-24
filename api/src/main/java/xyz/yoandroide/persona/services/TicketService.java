package xyz.yoandroide.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yoandroide.persona.entities.AcademicUnit;
import xyz.yoandroide.persona.entities.Analyzer;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.repositories.AcademicUnitRepository;
import xyz.yoandroide.persona.repositories.ClientRepository;
import xyz.yoandroide.persona.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private AcademicUnitRepository academicUnitRepository;

    public <S extends Ticket> S save(S entity) {
        return ticketRepository.save(entity);
    }


    public Optional<Ticket> findById(Long aLong) {
        return ticketRepository.findById(aLong);
    }

    public void delete(Long id) { ticketRepository.deleteById(id); }

    public boolean existById(Long id) {return ticketRepository.existsById(id); }


    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public long count() {
        return ticketRepository.count();
    }

    public AcademicUnit assignTicketToAcademicUnit(Long idAcademicUnit, Long idTicket) {
        List<Ticket> ticketList = null;
        AcademicUnit academicUnit = academicUnitRepository.findById(idAcademicUnit).get();
        Ticket ticket = ticketRepository.findById(idTicket).get();
        ticket.setState("Sin asignar");
        ticketList = academicUnit.getTickets();
        ticketList.add(ticket);
        academicUnit.setTickets(ticketList);
        return academicUnitRepository.save(academicUnit);
    }

}
