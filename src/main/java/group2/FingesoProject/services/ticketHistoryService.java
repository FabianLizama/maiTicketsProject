package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketHistoryEntity;
import group2.FingesoProject.repositories.ticketHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketHistoryService {
    @Autowired
    private final ticketHistoryRepository tickethistoryRepository;

    //Call service
    public ticketHistoryService(ticketHistoryRepository tickethistoryRepository){
        this.tickethistoryRepository = tickethistoryRepository;
    }

    //CREATE
    public ticketHistoryEntity createTickethistory(ticketHistoryEntity tickethistory){
        return tickethistoryRepository.save(tickethistory);
    }

    //READ
    public List<ticketHistoryEntity> getAllTickethistorys() {
        return tickethistoryRepository.findAll();
    }

    //READbyID
    public Optional<ticketHistoryEntity> getTickethistoryById(Long ID){
        return tickethistoryRepository.findById(ID);
    }

    //UPDATE
    public ticketHistoryEntity updateTickethistory(ticketHistoryEntity tickethistory){
        return tickethistoryRepository.save(tickethistory);
    }

    //DELETE(ID)x
    public void deleteTickethistory(Long ID){
        tickethistoryRepository.deleteById(ID);
    }
}
