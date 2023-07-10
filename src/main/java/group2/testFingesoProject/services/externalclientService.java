package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.externalclientEntity;
import group2.testFingesoProject.repositories.externalclientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class externalclientService {
    @Autowired
    externalclientRepository externalclientRepositoryInstance;
    public externalclientEntity createExternalclient(externalclientEntity newExternalclient) {
        //student validation
        return externalclientRepositoryInstance.save(newExternalclient);
    }
}
