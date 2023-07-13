package group2.FingesoProject.services;

import group2.FingesoProject.entities.leadershipEntity;
import group2.FingesoProject.repositories.leadershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class leadershipService {
    @Autowired
    private final leadershipRepository leadershipRepository;

    //Call service
    public leadershipService(leadershipRepository leadershipRepository){
        this.leadershipRepository = leadershipRepository;
    }

    //CREATE
    public leadershipEntity createLeadership(leadershipEntity leadership){
        return leadershipRepository.save(leadership);
    }

    //READ
    public List<leadershipEntity> getAllLeaderships() {
        return leadershipRepository.findAll();
    }

    //READbyID
    public Optional<leadershipEntity> getleadershipById(Long ID){
        return leadershipRepository.findById(ID);
    }

    //UPDATE
    public leadershipEntity updateLeadership(leadershipEntity leadership){
        return leadershipRepository.save(leadership);
    }

    //DELETE(ID)x
    public void deleteLeadership(Long ID){
        leadershipRepository.deleteById(ID);
    }
}
