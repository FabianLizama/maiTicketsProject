package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketDocumentEntity;
import group2.FingesoProject.repositories.ticketDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketDocumentService {
    @Autowired
    private final ticketDocumentRepository ticketdocumentRepository;

    //Call service
    public ticketDocumentService(ticketDocumentRepository ticketdocumentRepository){
        this.ticketdocumentRepository = ticketdocumentRepository;
    }

    //CREATE
    public ticketDocumentEntity createTicketdocument(ticketDocumentEntity ticketdocument){
        return ticketdocumentRepository.save(ticketdocument);
    }

    //READ
    public List<ticketDocumentEntity> getAllTicketdocuments() {
        return ticketdocumentRepository.findAll();
    }

    //READbyID
    public Optional<ticketDocumentEntity> getTicketdocumentById(Long ID){
        return ticketdocumentRepository.findById(ID);
    }

    //UPDATE
    public ticketDocumentEntity updateTicketdocument(ticketDocumentEntity ticketdocument){
        return ticketdocumentRepository.save(ticketdocument);
    }

    //DELETE(ID)x
    public void deleteTicketdocument(Long ID){
        ticketdocumentRepository.deleteById(ID);
    }
}
