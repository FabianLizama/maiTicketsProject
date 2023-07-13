package group2.FingesoProject.services;

import group2.FingesoProject.entities.ticketDocumentEntity;
import group2.FingesoProject.repositories.ticketDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketDocumentService {
    @Autowired
    private final ticketDocumentRepository ticketDocumentRepository;

    //Call service
    public ticketDocumentService(ticketDocumentRepository ticketDocumentRepository){
        this.ticketDocumentRepository = ticketDocumentRepository;
    }

    //CREATE
    public ticketDocumentEntity createTicketDocument(ticketDocumentEntity ticketDocument){
        return ticketDocumentRepository.save(ticketDocument);
    }

    //READ
    public List<ticketDocumentEntity> getAllTicketDocuments() {
        return ticketDocumentRepository.findAll();
    }

    //READbyID
    public Optional<ticketDocumentEntity> getTicketDocumentById(Long ID){
        return ticketDocumentRepository.findById(ID);
    }

    //UPDATE
    public ticketDocumentEntity updateTicketDocument(ticketDocumentEntity ticketDocument){
        return ticketDocumentRepository.save(ticketDocument);
    }

    //DELETE(ID)x
    public void deleteTicketDocument(Long ID){
        ticketDocumentRepository.deleteById(ID);
    }
}
