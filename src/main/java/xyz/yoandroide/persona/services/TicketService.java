package xyz.yoandroide.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public <S extends Ticket> S save(S entity) {
        return ticketRepository.save(entity);
    }


    public Optional<Ticket> findById(Long aLong) {
        return ticketRepository.findById(aLong);
    }


    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public long count() {
        return ticketRepository.count();
    }
}
