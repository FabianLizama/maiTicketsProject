package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.internalclientEntity;
import group2.testFingesoProject.repositories.internalclientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class internalclientService {
    @Autowired
    internalclientRepository internalclientRepositoryInstance;
    public internalclientEntity createInternalclient(internalclientEntity newInternalclient) {
        //student validation
        return internalclientRepositoryInstance.save(newInternalclient);
    }
}
