package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.clientPriorityEntity;
import group2.FingesoProject.services.clientPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Clientpriority")
public class clientPriorityController {
    @Autowired
    private final clientPriorityService clientPriorityServiceInstance;

    public clientPriorityController(clientPriorityService clientpriorityService){
        this.clientPriorityServiceInstance = clientpriorityService;
    }

    //CREATE
    @PostMapping
    public clientPriorityEntity createClientpriority(@RequestBody clientPriorityEntity clientpriority){
        return clientPriorityServiceInstance.createClientpriority(clientpriority);
    }

    //READ(ALL)
    @GetMapping
    public List<clientPriorityEntity> getAllClientprioritys(){
        return clientPriorityServiceInstance.getAlLClientprioritys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<clientPriorityEntity> getClientpriorityByID(@PathVariable Long ID){
        Optional<clientPriorityEntity> clientpriority = clientPriorityServiceInstance.getClientpriorityById(ID);
        return clientpriority.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public clientPriorityEntity updateClientpriority(@PathVariable Long ID, @RequestBody clientPriorityEntity clientpriority){
        clientpriority.setId_clientpriority(ID);
        return clientPriorityServiceInstance.updateClientpriority(clientpriority);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteClientpriority(@PathVariable Long ID){
        clientPriorityServiceInstance.deleteClientpriority(ID);
        return ResponseEntity.noContent().build();
    }
}
