package group2.FingesoProject.services;

import group2.FingesoProject.entities.ticketPriorityEntity;
import group2.FingesoProject.repositories.ticketPriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketPriorityService {
    @Autowired
    private final ticketPriorityRepository ticketPriorityRepository;

    //Call service
    public ticketPriorityService(ticketPriorityRepository ticketPriorityRepository){
        this.ticketPriorityRepository = ticketPriorityRepository;
    }

    //CREATE
    public ticketPriorityEntity createTicketPriority(ticketPriorityEntity ticketPriority){
        return ticketPriorityRepository.save(ticketPriority);
    }

    //READ
    public List<ticketPriorityEntity> getAllTicketPrioritys() {
        return ticketPriorityRepository.findAll();
    }

    //READbyID
    public Optional<ticketPriorityEntity> getTicketPriorityById(Long ID){
        return ticketPriorityRepository.findById(ID);
    }

    //UPDATE
    public ticketPriorityEntity updateTicketPriority(ticketPriorityEntity ticketPriority){
        return ticketPriorityRepository.save(ticketPriority);
    }

    //DELETE(ID)x
    public void deleteTicketPriority(Long ID){
        ticketPriorityRepository.deleteById(ID);
    }
}
