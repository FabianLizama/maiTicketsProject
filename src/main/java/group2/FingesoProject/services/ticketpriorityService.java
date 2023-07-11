package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketpriorityEntity;
import group2.FingesoProject.repositories.ticketpriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketpriorityService {
    @Autowired
    private final ticketpriorityRepository ticketpriorityRepository;

    //Call service
    public ticketpriorityService(ticketpriorityRepository ticketpriorityRepository){
        this.ticketpriorityRepository = ticketpriorityRepository;
    }

    //CREATE
    public ticketpriorityEntity createTicketpriority(ticketpriorityEntity ticketpriority){
        return ticketpriorityRepository.save(ticketpriority);
    }

    //READ
    public List<ticketpriorityEntity> getAllTicketprioritys() {
        return ticketpriorityRepository.findAll();
    }

    //READbyID
    public Optional<ticketpriorityEntity> getTicketpriorityById(Long ID){
        return ticketpriorityRepository.findById(ID);
    }

    //UPDATE
    public ticketpriorityEntity updateTicketpriority(ticketpriorityEntity ticketpriority){
        return ticketpriorityRepository.save(ticketpriority);
    }

    //DELETE(ID)x
    public void deleteTicketpriority(Long ID){
        ticketpriorityRepository.deleteById(ID);
    }
}
