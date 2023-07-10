package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.ticketEntity;
import group2.testFingesoProject.repositories.ticketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ticketService {
    @Autowired
    ticketRepository ticketRepositoryInstance;
    public ticketEntity createTicket(ticketEntity newticket) {
        //student validation
        return ticketRepositoryInstance.save(newticket);
    }
}
