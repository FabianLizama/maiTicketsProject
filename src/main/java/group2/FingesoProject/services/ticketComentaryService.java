package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketComentaryEntity;
import group2.FingesoProject.repositories.ticketComentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketComentaryService {
    @Autowired
    private final ticketComentaryRepository ticketcomentaryRepository;

    //Call service
    public ticketComentaryService(ticketComentaryRepository ticketcomentaryRepository){
        this.ticketcomentaryRepository = ticketcomentaryRepository;
    }

    //CREATE
    public ticketComentaryEntity createTicketcomentary(ticketComentaryEntity ticketcomentary){
        return ticketcomentaryRepository.save(ticketcomentary);
    }

    //READ
    public List<ticketComentaryEntity> getAllTicketcomentarys() {
        return ticketcomentaryRepository.findAll();
    }

    //READbyID
    public Optional<ticketComentaryEntity> getTicketcomentaryById(Long ID){
        return ticketcomentaryRepository.findById(ID);
    }

    //UPDATE
    public ticketComentaryEntity updateTicketcomentary(ticketComentaryEntity ticketcomentary){
        return ticketcomentaryRepository.save(ticketcomentary);
    }

    //DELETE(ID)x
    public void deleteTicketcomentary(Long ID){
        ticketcomentaryRepository.deleteById(ID);
    }
}
