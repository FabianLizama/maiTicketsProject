package group2.FingesoProject.services;

import group2.FingesoProject.entitites.externalclientEntity;
import group2.FingesoProject.repositories.externalclientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class externalclientService {
    @Autowired
    private final externalclientRepository externalclientRepository;

    //Call service
    public externalclientService(externalclientRepository externalclientRepository){
        this.externalclientRepository = externalclientRepository;
    }

    //CREATE
    public externalclientEntity createExternalclient(externalclientEntity externalclient){
        return externalclientRepository.save(externalclient);
    }

    //READ
    public List<externalclientEntity> getAllExternalclients() {
        return externalclientRepository.findAll();
    }

    //READbyID
    public Optional<externalclientEntity> getExternalclientById(Long ID){
        return externalclientRepository.findById(ID);
    }

    //UPDATE
    public externalclientEntity updateExternalclient(externalclientEntity externalclient){
        return externalclientRepository.save(externalclient);
    }

    //DELETE(ID)x
    public void deleteExternalclient(Long ID){
        externalclientRepository.deleteById(ID);
    }
}
