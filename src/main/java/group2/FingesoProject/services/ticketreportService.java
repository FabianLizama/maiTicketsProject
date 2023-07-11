package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketreportEntity;
import group2.FingesoProject.repositories.ticketreportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketreportService {
    @Autowired
    private final ticketreportRepository ticketreportRepository;

    //Call service
    public ticketreportService(ticketreportRepository ticketreportRepository){
        this.ticketreportRepository = ticketreportRepository;
    }

    //CREATE
    public ticketreportEntity createTicketreport(ticketreportEntity ticketreport){
        return ticketreportRepository.save(ticketreport);
    }

    //READ
    public List<ticketreportEntity> getAllTicketreports() {
        return ticketreportRepository.findAll();
    }

    //READbyID
    public Optional<ticketreportEntity> getTicketreportById(Long ID){
        return ticketreportRepository.findById(ID);
    }

    //UPDATE
    public ticketreportEntity updateTicketreport(ticketreportEntity ticketreport){
        return ticketreportRepository.save(ticketreport);
    }

    //DELETE(ID)x
    public void deleteTicketreport(Long ID){
        ticketreportRepository.deleteById(ID);
    }
}
