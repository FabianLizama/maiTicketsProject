package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketcategoryEntity;
import group2.FingesoProject.repositories.ticketcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketcategoryService {
    @Autowired
    private final ticketcategoryRepository ticketcategoryRepository;

    //Call service
    public ticketcategoryService(ticketcategoryRepository ticketcategoryRepository){
        this.ticketcategoryRepository = ticketcategoryRepository;
    }

    //CREATE
    public ticketcategoryEntity createTicketcategory(ticketcategoryEntity ticketcategory){
        return ticketcategoryRepository.save(ticketcategory);
    }

    //READ
    public List<ticketcategoryEntity> getAllTicketcategorys() {
        return ticketcategoryRepository.findAll();
    }

    //READbyID
    public Optional<ticketcategoryEntity> getTicketcategoryById(Long ID){
        return ticketcategoryRepository.findById(ID);
    }

    //UPDATE
    public ticketcategoryEntity updateTicketcategory(ticketcategoryEntity ticketcategory){
        return ticketcategoryRepository.save(ticketcategory);
    }

    //DELETE(ID)x
    public void deleteTicketcategory(Long ID){
        ticketcategoryRepository.deleteById(ID);
    }
}
