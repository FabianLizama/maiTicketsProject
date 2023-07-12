package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketCategoryEntity;
import group2.FingesoProject.repositories.ticketCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketCategoryService {
    @Autowired
    private final ticketCategoryRepository ticketcategoryRepository;

    //Call service
    public ticketCategoryService(ticketCategoryRepository ticketcategoryRepository){
        this.ticketcategoryRepository = ticketcategoryRepository;
    }

    //CREATE
    public ticketCategoryEntity createTicketcategory(ticketCategoryEntity ticketcategory){
        return ticketcategoryRepository.save(ticketcategory);
    }

    //READ
    public List<ticketCategoryEntity> getAllTicketcategorys() {
        return ticketcategoryRepository.findAll();
    }

    //READbyID
    public Optional<ticketCategoryEntity> getTicketcategoryById(Long ID){
        return ticketcategoryRepository.findById(ID);
    }

    //UPDATE
    public ticketCategoryEntity updateTicketcategory(ticketCategoryEntity ticketcategory){
        return ticketcategoryRepository.save(ticketcategory);
    }

    //DELETE(ID)x
    public void deleteTicketcategory(Long ID){
        ticketcategoryRepository.deleteById(ID);
    }
}
