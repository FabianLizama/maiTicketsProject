package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketReportEntity;
import group2.FingesoProject.repositories.ticketReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketReportService {
    @Autowired
    private final ticketReportRepository ticketreportRepository;

    //Call service
    public ticketReportService(ticketReportRepository ticketreportRepository){
        this.ticketreportRepository = ticketreportRepository;
    }

    //CREATE
    public ticketReportEntity createTicketreport(ticketReportEntity ticketreport){
        return ticketreportRepository.save(ticketreport);
    }

    //READ
    public List<ticketReportEntity> getAllTicketreports() {
        return ticketreportRepository.findAll();
    }

    //READbyID
    public Optional<ticketReportEntity> getTicketreportById(Long ID){
        return ticketreportRepository.findById(ID);
    }

    //UPDATE
    public ticketReportEntity updateTicketreport(ticketReportEntity ticketreport){
        return ticketreportRepository.save(ticketreport);
    }

    //DELETE(ID)x
    public void deleteTicketreport(Long ID){
        ticketreportRepository.deleteById(ID);
    }
}
