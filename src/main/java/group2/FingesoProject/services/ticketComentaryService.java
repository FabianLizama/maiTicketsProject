package group2.FingesoProject.services;

import group2.FingesoProject.entities.ticketComentaryEntity;
import group2.FingesoProject.repositories.ticketComentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketComentaryService {
    @Autowired
    private final ticketComentaryRepository ticketComentaryRepository;

    //Call service
    public ticketComentaryService(ticketComentaryRepository ticketComentaryRepository){
        this.ticketComentaryRepository = ticketComentaryRepository;
    }

    //CREATE
    public ticketComentaryEntity createTicketComentary(ticketComentaryEntity ticketComentary){
        return ticketComentaryRepository.save(ticketComentary);
    }

    //READ
    public List<ticketComentaryEntity> getAllTicketComentarys() {
        return ticketComentaryRepository.findAll();
    }

    //READbyID
    public Optional<ticketComentaryEntity> getTicketComentaryById(Long ID){
        return ticketComentaryRepository.findById(ID);
    }

    //UPDATE
    public ticketComentaryEntity updateTicketComentary(ticketComentaryEntity ticketComentary){
        return ticketComentaryRepository.save(ticketComentary);
    }

    //DELETE(ID)x
    public void deleteTicketComentary(Long ID){
        ticketComentaryRepository.deleteById(ID);
    }
}
