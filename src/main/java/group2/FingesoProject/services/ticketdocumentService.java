package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketdocumentEntity;
import group2.FingesoProject.repositories.ticketdocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketdocumentService {
    @Autowired
    private final ticketdocumentRepository ticketdocumentRepository;

    //Call service
    public ticketdocumentService(ticketdocumentRepository ticketdocumentRepository){
        this.ticketdocumentRepository = ticketdocumentRepository;
    }

    //CREATE
    public ticketdocumentEntity createTicketdocument(ticketdocumentEntity ticketdocument){
        return ticketdocumentRepository.save(ticketdocument);
    }

    //READ
    public List<ticketdocumentEntity> getAllTicketdocuments() {
        return ticketdocumentRepository.findAll();
    }

    //READbyID
    public Optional<ticketdocumentEntity> getTicketdocumentById(Long ID){
        return ticketdocumentRepository.findById(ID);
    }

    //UPDATE
    public ticketdocumentEntity updateTicketdocument(ticketdocumentEntity ticketdocument){
        return ticketdocumentRepository.save(ticketdocument);
    }

    //DELETE(ID)x
    public void deleteTicketdocument(Long ID){
        ticketdocumentRepository.deleteById(ID);
    }
}
