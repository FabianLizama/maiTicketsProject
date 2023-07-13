package group2.FingesoProject.services;

import group2.FingesoProject.entities.ticketStateEntity;
import group2.FingesoProject.repositories.ticketStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketStateService {
    @Autowired
    private final ticketStateRepository ticketStateRepository;

    //Call service
    public ticketStateService(ticketStateRepository ticketStateRepository){
        this.ticketStateRepository = ticketStateRepository;
    }

    //CREATE
    public ticketStateEntity createTicketState(ticketStateEntity ticketState){
        return ticketStateRepository.save(ticketState);
    }

    //READ
    public List<ticketStateEntity> getAllTicketStates() {
        return ticketStateRepository.findAll();
    }

    //READbyID
    public Optional<ticketStateEntity> getTicketStateById(Long ID){
        return ticketStateRepository.findById(ID);
    }

    //UPDATE
    public ticketStateEntity updateTicketState(ticketStateEntity ticketState){
        return ticketStateRepository.save(ticketState);
    }

    //DELETE(ID)x
    public void deleteTicketState(Long ID){
        ticketStateRepository.deleteById(ID);
    }
}
