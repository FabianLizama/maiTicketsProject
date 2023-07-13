package group2.FingesoProject.services;

import group2.FingesoProject.entities.ticketEntity;
import group2.FingesoProject.repositories.ticketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketService {
    @Autowired
    private final ticketRepository ticketRepository;

    //Call service
    public ticketService(ticketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    //CREATE
    public ticketEntity createTicket(ticketEntity ticket){
        return ticketRepository.save(ticket);
    }

    //READ
    public List<ticketEntity> getAllTickets() {
        return ticketRepository.findAll();
    }

    //READbyID
    public Optional<ticketEntity> getTicketById(Long ID){
        return ticketRepository.findById(ID);
    }

    //UPDATE
    public ticketEntity updateTicket(ticketEntity ticket){
        return ticketRepository.save(ticket);
    }

    //DELETE(ID)x
    public void deleteTicket(Long ID){
        ticketRepository.deleteById(ID);
    }
}
