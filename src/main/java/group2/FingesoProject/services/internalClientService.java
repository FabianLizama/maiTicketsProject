package group2.FingesoProject.services;

import group2.FingesoProject.entities.internalClientEntity;
import group2.FingesoProject.repositories.internalClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class internalClientService {
    @Autowired
    private final internalClientRepository internalClientRepository;

    //Call service
    public internalClientService(internalClientRepository internalClientRepository){
        this.internalClientRepository = internalClientRepository;
    }

    //CREATE
    public internalClientEntity createInternalClient(internalClientEntity internalClient){
        return internalClientRepository.save(internalClient);
    }

    //READ
    public List<internalClientEntity> getAllInternalClients() {
        return internalClientRepository.findAll();
    }

    //READbyID
    public Optional<internalClientEntity> getInternalClientById(Long ID){
        return internalClientRepository.findById(ID);
    }

    //UPDATE
    public internalClientEntity updateInternalClient(internalClientEntity internalClient){
        return internalClientRepository.save(internalClient);
    }

    //DELETE(ID)x
    public void deleteInternalClient(Long ID){
        internalClientRepository.deleteById(ID);
    }
}
