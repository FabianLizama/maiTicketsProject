package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.ticketcategoryEntity;
import group2.testFingesoProject.repositories.ticketcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ticketcategoryService {
    @Autowired
    ticketcategoryRepository ticketcategoryRepositoryInstance;
    public ticketcategoryEntity createTicketcategory(ticketcategoryEntity newticketcategory) {
        //student validation
        return ticketcategoryRepositoryInstance.save(newticketcategory);
    }
}
