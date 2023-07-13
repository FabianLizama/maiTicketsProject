package group2.FingesoProject.services;

import group2.FingesoProject.entities.ticketReportEntity;
import group2.FingesoProject.repositories.ticketReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketReportService {
    @Autowired
    private final ticketReportRepository ticketReportRepository;

    //Call service
    public ticketReportService(ticketReportRepository ticketReportRepository){
        this.ticketReportRepository = ticketReportRepository;
    }

    //CREATE
    public ticketReportEntity createTicketReport(ticketReportEntity ticketReport){
        return ticketReportRepository.save(ticketReport);
    }

    //READ
    public List<ticketReportEntity> getAllTicketReports() {
        return ticketReportRepository.findAll();
    }

    //READbyID
    public Optional<ticketReportEntity> getTicketReportById(Long ID){
        return ticketReportRepository.findById(ID);
    }

    //UPDATE
    public ticketReportEntity updateTicketReport(ticketReportEntity ticketReport){
        return ticketReportRepository.save(ticketReport);
    }

    //DELETE(ID)x
    public void deleteTicketReport(Long ID){
        ticketReportRepository.deleteById(ID);
    }
}
