package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.clientpriorityEntity;
import group2.FingesoProject.services.clientpriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Clientpriority")
public class clientpriorityController {
    @Autowired
    private final clientpriorityService clientpriorityServiceInstance;

    public clientpriorityController(clientpriorityService clientpriorityService){
        this.clientpriorityServiceInstance = clientpriorityService;
    }

    //CREATE
    @PostMapping
    public clientpriorityEntity createClientpriority(@RequestBody clientpriorityEntity clientpriority){
        return clientpriorityServiceInstance.createClientpriority(clientpriority);
    }

    //READ(ALL)
    @GetMapping
    public List<clientpriorityEntity> getAllClientprioritys(){
        return clientpriorityServiceInstance.getAlLClientprioritys();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<clientpriorityEntity> getClientpriorityByID(@PathVariable Long ID){
        Optional<clientpriorityEntity> clientpriority = clientpriorityServiceInstance.getClientpriorityById(ID);
        return clientpriority.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public clientpriorityEntity updateClientpriority(@PathVariable Long ID, @RequestBody clientpriorityEntity clientpriority){
        clientpriority.setId_clientpriority(ID);
        return clientpriorityServiceInstance.updateClientpriority(clientpriority);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteClientpriority(@PathVariable Long ID){
        clientpriorityServiceInstance.deleteClientpriority(ID);
        return ResponseEntity.noContent().build();
    }
}
