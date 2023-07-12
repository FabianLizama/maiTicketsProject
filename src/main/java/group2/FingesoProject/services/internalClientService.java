package group2.FingesoProject.services;

import group2.FingesoProject.entitites.internalClientEntity;
import group2.FingesoProject.repositories.internalClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class internalClientService {
    @Autowired
    private final internalClientRepository internalclientRepository;

    //Call service
    public internalClientService(internalClientRepository internalclientRepository){
        this.internalclientRepository = internalclientRepository;
    }

    //CREATE
    public internalClientEntity createInternalclient(internalClientEntity internalclient){
        return internalclientRepository.save(internalclient);
    }

    //READ
    public List<internalClientEntity> getAllInternalclients() {
        return internalclientRepository.findAll();
    }

    //READbyID
    public Optional<internalClientEntity> getInternalclientById(Long ID){
        return internalclientRepository.findById(ID);
    }

    //UPDATE
    public internalClientEntity updateInternalclient(internalClientEntity internalclient){
        return internalclientRepository.save(internalclient);
    }

    //DELETE(ID)x
    public void deleteInternalclient(Long ID){
        internalclientRepository.deleteById(ID);
    }
}
