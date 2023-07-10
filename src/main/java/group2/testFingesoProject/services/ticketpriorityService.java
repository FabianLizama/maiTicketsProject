package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.ticketpriorityEntity;
import group2.testFingesoProject.repositories.ticketpriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ticketpriorityService {
    @Autowired
    ticketpriorityRepository ticketpriorityRepositoryInstance;
    public ticketpriorityEntity createTicketpriority(ticketpriorityEntity newticketpriority) {
        //student validation
        return ticketpriorityRepositoryInstance.save(newticketpriority);
    }
}
