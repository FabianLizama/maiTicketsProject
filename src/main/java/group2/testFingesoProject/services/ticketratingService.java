package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.ticketratingEntity;
import group2.testFingesoProject.repositories.ticketratingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ticketratingService {
    @Autowired
    ticketratingRepository ticketratingRepositoryInstance;
    public ticketratingEntity createTicketrating(ticketratingEntity newticketrating) {
        //student validation
        return ticketratingRepositoryInstance.save(newticketrating);
    }
}
