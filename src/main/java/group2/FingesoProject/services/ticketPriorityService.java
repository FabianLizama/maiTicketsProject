package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketPriorityEntity;
import group2.FingesoProject.repositories.ticketPriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketPriorityService {
    @Autowired
    private final ticketPriorityRepository ticketpriorityRepository;

    //Call service
    public ticketPriorityService(ticketPriorityRepository ticketpriorityRepository){
        this.ticketpriorityRepository = ticketpriorityRepository;
    }

    //CREATE
    public ticketPriorityEntity createTicketpriority(ticketPriorityEntity ticketpriority){
        return ticketpriorityRepository.save(ticketpriority);
    }

    //READ
    public List<ticketPriorityEntity> getAllTicketprioritys() {
        return ticketpriorityRepository.findAll();
    }

    //READbyID
    public Optional<ticketPriorityEntity> getTicketpriorityById(Long ID){
        return ticketpriorityRepository.findById(ID);
    }

    //UPDATE
    public ticketPriorityEntity updateTicketpriority(ticketPriorityEntity ticketpriority){
        return ticketpriorityRepository.save(ticketpriority);
    }

    //DELETE(ID)x
    public void deleteTicketpriority(Long ID){
        ticketpriorityRepository.deleteById(ID);
    }
}
