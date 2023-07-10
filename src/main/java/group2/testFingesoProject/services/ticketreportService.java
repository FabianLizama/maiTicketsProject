package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.ticketreportEntity;
import group2.testFingesoProject.repositories.ticketreportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ticketreportService {
    @Autowired
    ticketreportRepository ticketreportRepositoryInstance;
    public ticketreportEntity createTicketreport(ticketreportEntity newticketreport) {
        //student validation
        return ticketreportRepositoryInstance.save(newticketreport);
    }
}
