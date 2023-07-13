package group2.FingesoProject.services;

import group2.FingesoProject.entities.ticketCategoryEntity;
import group2.FingesoProject.repositories.ticketCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketCategoryService {
    @Autowired
    private final ticketCategoryRepository ticketCategoryRepository;

    //Call service
    public ticketCategoryService(ticketCategoryRepository ticketCategoryRepository){
        this.ticketCategoryRepository = ticketCategoryRepository;
    }

    //CREATE
    public ticketCategoryEntity createTicketCategory(ticketCategoryEntity ticketCategory){
        return ticketCategoryRepository.save(ticketCategory);
    }

    //READ
    public List<ticketCategoryEntity> getAllTicketCategorys() {
        return ticketCategoryRepository.findAll();
    }

    //READbyID
    public Optional<ticketCategoryEntity> getTicketCategoryById(Long ID){
        return ticketCategoryRepository.findById(ID);
    }

    //UPDATE
    public ticketCategoryEntity updateTicketCategory(ticketCategoryEntity ticketCategory){
        return ticketCategoryRepository.save(ticketCategory);
    }

    //DELETE(ID)x
    public void deleteTicketCategory(Long ID){
        ticketCategoryRepository.deleteById(ID);
    }
}
