package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.clientPriorityEntity;
import group2.FingesoProject.services.clientPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ClientPriority")
public class clientPriorityController {
    @Autowired
    private final clientPriorityService clientPriorityServiceInstance;

    public clientPriorityController(clientPriorityService clientPriorityService){
        this.clientPriorityServiceInstance = clientPriorityService;
    }

    //CREATE
    @PostMapping
    public clientPriorityEntity createClientPriority(@RequestBody clientPriorityEntity clientPriority){
        return clientPriorityServiceInstance.createClientPriority(clientPriority);
    }

    //READ(ALL)
    @GetMapping
    public List<clientPriorityEntity> getAllClientPrioritys(){
        return clientPriorityServiceInstance.getAlLClientPrioritys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<clientPriorityEntity> getClientPriorityByID(@PathVariable Long ID){
        Optional<clientPriorityEntity> clientPriority = clientPriorityServiceInstance.getClientPriorityById(ID);
        return clientPriority.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public clientPriorityEntity updateClientPriority(@PathVariable Long ID, @RequestBody clientPriorityEntity clientPriority){
        clientPriority.setId_clientPriority(ID);
        return clientPriorityServiceInstance.updateClientPriority(clientPriority);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteClientPriority(@PathVariable Long ID){
        clientPriorityServiceInstance.deleteClientPriority(ID);
        return ResponseEntity.noContent().build();
    }
}
