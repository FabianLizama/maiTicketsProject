package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.ticketstateEntity;
import group2.testFingesoProject.repositories.ticketstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ticketstateService {
    @Autowired
    ticketstateRepository ticketstateRepositoryInstance;
    public ticketstateEntity createTicketstate(ticketstateEntity newticketstate) {
        //student validation
        return ticketstateRepositoryInstance.save(newticketstate);
    }
}
