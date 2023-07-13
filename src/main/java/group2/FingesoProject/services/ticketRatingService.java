package group2.FingesoProject.services;

import group2.FingesoProject.entities.ticketRatingEntity;
import group2.FingesoProject.repositories.ticketRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketRatingService {
    @Autowired
    private final ticketRatingRepository ticketratingRepository;

    //Call service
    public ticketRatingService(ticketRatingRepository ticketratingRepository){
        this.ticketratingRepository = ticketratingRepository;
    }

    //CREATE
    public ticketRatingEntity createTicketrating(ticketRatingEntity ticketrating){
        return ticketratingRepository.save(ticketrating);
    }

    //READ
    public List<ticketRatingEntity> getAllTicketratings() {
        return ticketratingRepository.findAll();
    }

    //READbyID
    public Optional<ticketRatingEntity> getTicketratingById(Long ID){
        return ticketratingRepository.findById(ID);
    }

    //UPDATE
    public ticketRatingEntity updateTicketrating(ticketRatingEntity ticketrating){
        return ticketratingRepository.save(ticketrating);
    }

    //DELETE(ID)x
    public void deleteTicketrating(Long ID){
        ticketratingRepository.deleteById(ID);
    }
}
