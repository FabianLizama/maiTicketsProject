package group2.FingesoProject.services;

import group2.FingesoProject.entitites.tickethistoryEntity;
import group2.FingesoProject.repositories.tickethistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class tickethistoryService {
    @Autowired
    private final tickethistoryRepository tickethistoryRepository;

    //Call service
    public tickethistoryService(tickethistoryRepository tickethistoryRepository){
        this.tickethistoryRepository = tickethistoryRepository;
    }

    //CREATE
    public tickethistoryEntity createTickethistory(tickethistoryEntity tickethistory){
        return tickethistoryRepository.save(tickethistory);
    }

    //READ
    public List<tickethistoryEntity> getAllTickethistorys() {
        return tickethistoryRepository.findAll();
    }

    //READbyID
    public Optional<tickethistoryEntity> getTickethistoryById(Long ID){
        return tickethistoryRepository.findById(ID);
    }

    //UPDATE
    public tickethistoryEntity updateTickethistory(tickethistoryEntity tickethistory){
        return tickethistoryRepository.save(tickethistory);
    }

    //DELETE(ID)x
    public void deleteTickethistory(Long ID){
        tickethistoryRepository.deleteById(ID);
    }
}
