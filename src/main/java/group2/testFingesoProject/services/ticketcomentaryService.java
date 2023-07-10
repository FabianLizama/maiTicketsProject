package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.ticketcomentaryEntity;
import group2.testFingesoProject.repositories.ticketcomentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ticketcomentaryService {
    @Autowired
    ticketcomentaryRepository ticketcomentaryRepositoryInstance;
    public ticketcomentaryEntity createTicketcomentary(ticketcomentaryEntity newticketcomentary) {
        //student validation
        return ticketcomentaryRepositoryInstance.save(newticketcomentary);
    }
}
