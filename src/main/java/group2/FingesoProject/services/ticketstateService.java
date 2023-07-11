package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketstateEntity;
import group2.FingesoProject.repositories.ticketstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketstateService {
    @Autowired
    private final ticketstateRepository ticketstateRepository;

    //Call service
    public ticketstateService(ticketstateRepository ticketstateRepository){
        this.ticketstateRepository = ticketstateRepository;
    }

    //CREATE
    public ticketstateEntity createTicketstate(ticketstateEntity ticketstate){
        return ticketstateRepository.save(ticketstate);
    }

    //READ
    public List<ticketstateEntity> getAllTicketstates() {
        return ticketstateRepository.findAll();
    }

    //READbyID
    public Optional<ticketstateEntity> getTicketstateById(Long ID){
        return ticketstateRepository.findById(ID);
    }

    //UPDATE
    public ticketstateEntity updateTicketstate(ticketstateEntity ticketstate){
        return ticketstateRepository.save(ticketstate);
    }

    //DELETE(ID)x
    public void deleteTicketstate(Long ID){
        ticketstateRepository.deleteById(ID);
    }
}
