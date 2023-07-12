package group2.FingesoProject.services;

import group2.FingesoProject.entitites.clientPriorityEntity;
import group2.FingesoProject.repositories.clientPriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clientPriorityService {
    @Autowired
    private final clientPriorityRepository clientpriorityRepository;

    //Call service
    public clientPriorityService(clientPriorityRepository clientpriorityRepository){
        this.clientpriorityRepository = clientpriorityRepository;
    }

    //CREATE
    public clientPriorityEntity createClientpriority(clientPriorityEntity clientpriority){
        return clientpriorityRepository.save(clientpriority);
    }

    //READ
    public List<clientPriorityEntity> getAlLClientprioritys() {
        return clientpriorityRepository.findAll();
    }

    //READbyID
    public Optional<clientPriorityEntity> getClientpriorityById(Long ID){
        return clientpriorityRepository.findById(ID);
    }

    //UPDATE
    public clientPriorityEntity updateClientpriority(clientPriorityEntity clientpriority){
        return clientpriorityRepository.save(clientpriority);
    }

    //DELETE(ID)x
    public void deleteClientpriority(Long ID){
        clientpriorityRepository.deleteById(ID);
    }
}
