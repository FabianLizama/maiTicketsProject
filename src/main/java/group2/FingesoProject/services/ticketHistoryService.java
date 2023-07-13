package group2.FingesoProject.services;

import group2.FingesoProject.entities.ticketHistoryEntity;
import group2.FingesoProject.repositories.ticketHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketHistoryService {
    @Autowired
    private final ticketHistoryRepository ticketHistoryRepository;

    //Call service
    public ticketHistoryService(ticketHistoryRepository ticketHistoryRepository){
        this.ticketHistoryRepository = ticketHistoryRepository;
    }

    //CREATE
    public ticketHistoryEntity createTicketHistory(ticketHistoryEntity ticketHistory){
        return ticketHistoryRepository.save(ticketHistory);
    }

    //READ
    public List<ticketHistoryEntity> getAllTicketHistorys() {
        return ticketHistoryRepository.findAll();
    }

    //READbyID
    public Optional<ticketHistoryEntity> getTicketHistoryById(Long ID){
        return ticketHistoryRepository.findById(ID);
    }

    //UPDATE
    public ticketHistoryEntity updateTicketHistory(ticketHistoryEntity ticketHistory){
        return ticketHistoryRepository.save(ticketHistory);
    }

    //DELETE(ID)x
    public void deleteTicketHistory(Long ID){
        ticketHistoryRepository.deleteById(ID);
    }
}
