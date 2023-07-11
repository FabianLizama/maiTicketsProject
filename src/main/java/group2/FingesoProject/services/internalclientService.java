package group2.FingesoProject.services;

import group2.FingesoProject.entitites.internalclientEntity;
import group2.FingesoProject.repositories.internalclientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class internalclientService {
    @Autowired
    private final internalclientRepository internalclientRepository;

    //Call service
    public internalclientService(internalclientRepository internalclientRepository){
        this.internalclientRepository = internalclientRepository;
    }

    //CREATE
    public internalclientEntity createInternalclient(internalclientEntity internalclient){
        return internalclientRepository.save(internalclient);
    }

    //READ
    public List<internalclientEntity> getAllInternalclients() {
        return internalclientRepository.findAll();
    }

    //READbyID
    public Optional<internalclientEntity> getInternalclientById(Long ID){
        return internalclientRepository.findById(ID);
    }

    //UPDATE
    public internalclientEntity updateInternalclient(internalclientEntity internalclient){
        return internalclientRepository.save(internalclient);
    }

    //DELETE(ID)x
    public void deleteInternalclient(Long ID){
        internalclientRepository.deleteById(ID);
    }
}
