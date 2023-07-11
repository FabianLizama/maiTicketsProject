package group2.FingesoProject.services;

import group2.FingesoProject.entitites.ticketratingEntity;
import group2.FingesoProject.repositories.ticketratingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ticketratingService {
    @Autowired
    private final ticketratingRepository ticketratingRepository;

    //Call service
    public ticketratingService(ticketratingRepository ticketratingRepository){
        this.ticketratingRepository = ticketratingRepository;
    }

    //CREATE
    public ticketratingEntity createTicketrating(ticketratingEntity ticketrating){
        return ticketratingRepository.save(ticketrating);
    }

    //READ
    public List<ticketratingEntity> getAllTicketratings() {
        return ticketratingRepository.findAll();
    }

    //READbyID
    public Optional<ticketratingEntity> getTicketratingById(Long ID){
        return ticketratingRepository.findById(ID);
    }

    //UPDATE
    public ticketratingEntity updateTicketrating(ticketratingEntity ticketrating){
        return ticketratingRepository.save(ticketrating);
    }

    //DELETE(ID)x
    public void deleteTicketrating(Long ID){
        ticketratingRepository.deleteById(ID);
    }
}
