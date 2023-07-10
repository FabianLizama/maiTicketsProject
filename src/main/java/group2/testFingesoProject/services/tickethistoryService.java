package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.tickethistoryEntity;
import group2.testFingesoProject.repositories.tickethistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class tickethistoryService {
    @Autowired
    tickethistoryRepository tickethistoryRepositoryInstance;
    public tickethistoryEntity createTickethistory(tickethistoryEntity newtickethistory) {
        //student validation
        return tickethistoryRepositoryInstance.save(newtickethistory);
    }
}
