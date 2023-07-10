package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.ticketdocumentEntity;
import group2.testFingesoProject.repositories.ticketdocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ticketdocumentService {
    @Autowired
    ticketdocumentRepository ticketdocumentRepositoryInstance;
    public ticketdocumentEntity createTicketdocument(ticketdocumentEntity newticketdocument) {
        //student validation
        return ticketdocumentRepositoryInstance.save(newticketdocument);
    }
}
