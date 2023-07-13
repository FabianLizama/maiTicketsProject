package group2.FingesoProject.services;

import group2.FingesoProject.entities.externalClientEntity;
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
    public externalClientEntity createExternalClient(externalClientEntity externalClient){
        return externalClientRepository.save(externalClient);
    }

    //READ
    public List<externalClientEntity> getAllExternalClients() {
        return externalClientRepository.findAll();
    }

    //READbyID
    public Optional<externalClientEntity> getExternalClientById(Long ID){
        return externalClientRepository.findById(ID);
    }

    //UPDATE
    public externalClientEntity updateExternalClient(externalClientEntity externalClient){
        return externalClientRepository.save(externalClient);
    }

    //DELETE(ID)x
    public void deleteExternalClient(Long ID){
        externalClientRepository.deleteById(ID);
    }
}
