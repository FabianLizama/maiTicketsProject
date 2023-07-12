package group2.FingesoProject.services;

import group2.FingesoProject.entitites.externalClientEntity;
import group2.FingesoProject.repositories.externalClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class externalClientService {
    @Autowired
    private final externalClientRepository externalclientRepository;

    //Call service
    public externalClientService(externalClientRepository externalclientRepository){
        this.externalclientRepository = externalclientRepository;
    }

    //CREATE
    public externalClientEntity createExternalclient(externalClientEntity externalclient){
        return externalclientRepository.save(externalclient);
    }

    //READ
    public List<externalClientEntity> getAllExternalclients() {
        return externalclientRepository.findAll();
    }

    //READbyID
    public Optional<externalClientEntity> getExternalclientById(Long ID){
        return externalclientRepository.findById(ID);
    }

    //UPDATE
    public externalClientEntity updateExternalclient(externalClientEntity externalclient){
        return externalclientRepository.save(externalclient);
    }

    //DELETE(ID)x
    public void deleteExternalclient(Long ID){
        externalclientRepository.deleteById(ID);
    }
}
