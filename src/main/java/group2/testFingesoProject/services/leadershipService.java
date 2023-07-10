package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.leadershipEntity;
import group2.testFingesoProject.entitites.studentEntity;
import group2.testFingesoProject.repositories.leadershipRepository;
import group2.testFingesoProject.repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class leadershipService {
    @Autowired
    leadershipRepository leadershipRepositoryInstance;
    public leadershipEntity createLeadership(leadershipEntity newLeadership) {
        //student validation
        return leadershipRepositoryInstance.save(newLeadership);
    }
}
