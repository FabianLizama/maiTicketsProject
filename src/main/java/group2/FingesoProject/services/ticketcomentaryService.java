package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketcomentaryEntity;
import group2.FingesoProject.repositories.ticketcomentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketcomentaryService {
    @Autowired
    private final ticketcomentaryRepository ticketcomentaryRepository;

    //Call service
    public ticketcomentaryService(ticketcomentaryRepository ticketcomentaryRepository){
        this.ticketcomentaryRepository = ticketcomentaryRepository;
    }

    //CREATE
    public ticketcomentaryEntity createTicketcomentary(ticketcomentaryEntity ticketcomentary){
        return ticketcomentaryRepository.save(ticketcomentary);
    }

    //READ
    public List<ticketcomentaryEntity> getAllTicketcomentarys() {
        return ticketcomentaryRepository.findAll();
    }

    //READbyID
    public Optional<ticketcomentaryEntity> getTicketcomentaryById(Long ID){
        return ticketcomentaryRepository.findById(ID);
    }

    //UPDATE
    public ticketcomentaryEntity updateTicketcomentary(ticketcomentaryEntity ticketcomentary){
        return ticketcomentaryRepository.save(ticketcomentary);
    }

    //DELETE(ID)x
    public void deleteTicketcomentary(Long ID){
        ticketcomentaryRepository.deleteById(ID);
    }
}
