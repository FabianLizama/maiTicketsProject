package group2.FingesoProject.services;

import group2.FingesoProject.entitites.clientpriorityEntity;
import group2.FingesoProject.repositories.clientpriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clientpriorityService {
    @Autowired
    private final clientpriorityRepository clientpriorityRepository;

    //Call service
    public clientpriorityService(clientpriorityRepository clientpriorityRepository){
        this.clientpriorityRepository = clientpriorityRepository;
    }

    //CREATE
    public clientpriorityEntity createClientpriority(clientpriorityEntity clientpriority){
        return clientpriorityRepository.save(clientpriority);
    }

    //READ
    public List<clientpriorityEntity> getAlLClientprioritys() {
        return clientpriorityRepository.findAll();
    }

    //READbyID
    public Optional<clientpriorityEntity> getClientpriorityById(Long ID){
        return clientpriorityRepository.findById(ID);
    }

    //UPDATE
    public clientpriorityEntity updateClientpriority(clientpriorityEntity clientpriority){
        return clientpriorityRepository.save(clientpriority);
    }

    //DELETE(ID)x
    public void deleteClientpriority(Long ID){
        clientpriorityRepository.deleteById(ID);
    }
}
