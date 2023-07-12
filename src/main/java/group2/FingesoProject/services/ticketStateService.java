package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketStateEntity;
import group2.FingesoProject.repositories.ticketStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketStateService {
    @Autowired
    private final ticketStateRepository ticketstateRepository;

    //Call service
    public ticketStateService(ticketStateRepository ticketstateRepository){
        this.ticketstateRepository = ticketstateRepository;
    }

    //CREATE
    public ticketStateEntity createTicketstate(ticketStateEntity ticketstate){
        return ticketstateRepository.save(ticketstate);
    }

    //READ
    public List<ticketStateEntity> getAllTicketstates() {
        return ticketstateRepository.findAll();
    }

    //READbyID
    public Optional<ticketStateEntity> getTicketstateById(Long ID){
        return ticketstateRepository.findById(ID);
    }

    //UPDATE
    public ticketStateEntity updateTicketstate(ticketStateEntity ticketstate){
        return ticketstateRepository.save(ticketstate);
    }

    //DELETE(ID)x
    public void deleteTicketstate(Long ID){
        ticketstateRepository.deleteById(ID);
    }
}
