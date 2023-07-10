package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.clientpriorityEntity;
import group2.testFingesoProject.repositories.clientpriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clientpriorityService {
    @Autowired
    clientpriorityRepository clientpriorityRepositoryInstance;
    public clientpriorityEntity createClientpriority(clientpriorityEntity newClientpriority) {
        //student validation
        return clientpriorityRepositoryInstance.save(newClientpriority);
    }
}
