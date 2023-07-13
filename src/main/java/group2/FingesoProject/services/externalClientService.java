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
    private final externalClientRepository externalClientRepository;

    //Call service
    public externalClientService(externalClientRepository externalClientRepository){
        this.externalClientRepository = externalClientRepository;
    }

    //CREATE
    public externalClientEntity createExternalclient(externalClientEntity externalClient){
        return externalClientRepository.save(externalClient);
    }

    //READ
    public List<externalClientEntity> getAllExternalclients() {
        return externalClientRepository.findAll();
    }

    //READbyID
    public Optional<externalClientEntity> getExternalclientById(Long ID){
        return externalClientRepository.findById(ID);
    }

    //UPDATE
    public externalClientEntity updateExternalclient(externalClientEntity externalClient){
        return externalClientRepository.save(externalClient);
    }

    //DELETE(ID)x
    public void deleteExternalclient(Long ID){
        externalClientRepository.deleteById(ID);
    }
}
