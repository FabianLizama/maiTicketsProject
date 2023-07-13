package group2.FingesoProject.services;

import group2.FingesoProject.entities.clientPriorityEntity;
import group2.FingesoProject.repositories.clientPriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clientPriorityService {
    @Autowired
    private final clientPriorityRepository clientPriorityRepository;

    //Call service
    public clientPriorityService(clientPriorityRepository clientPriorityRepository){
        this.clientPriorityRepository = clientPriorityRepository;
    }

    //CREATE
    public clientPriorityEntity createClientPriority(clientPriorityEntity clientPriority){
        return clientPriorityRepository.save(clientPriority);
    }

    //READ
    public List<clientPriorityEntity> getAlLClientPrioritys() {
        return clientPriorityRepository.findAll();
    }

    //READbyID
    public Optional<clientPriorityEntity> getClientPriorityById(Long ID){
        return clientPriorityRepository.findById(ID);
    }

    //UPDATE
    public clientPriorityEntity updateClientPriority(clientPriorityEntity clientPriority){
        return clientPriorityRepository.save(clientPriority);
    }

    //DELETE(ID)x
    public void deleteClientPriority(Long ID){
        clientPriorityRepository.deleteById(ID);
    }
}
