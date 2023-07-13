package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.internalClientEntity;
import group2.FingesoProject.services.internalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/InternalClient")
public class internalClientController {
    @Autowired
    private final internalClientService internalClientServiceInstance;

    public internalClientController(internalClientService internalClientService){
        this.internalClientServiceInstance = internalClientService;
    }

    //CREATE
    @PostMapping
    public internalClientEntity createInternalClient(@RequestBody internalClientEntity internalClient){
        return internalClientServiceInstance.createInternalClient(internalClient);
    }

    //READ(ALL)
    @GetMapping
    public List<internalClientEntity> getAllInternalClients(){
        return internalClientServiceInstance.getAllInternalClients();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<internalClientEntity> getInternalClientByID(@PathVariable Long ID){
        Optional<internalClientEntity> internalClient = internalClientServiceInstance.getInternalClientById(ID);
        return internalClient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public internalClientEntity updateInternalClient(@PathVariable Long ID, @RequestBody internalClientEntity internalClient){
        internalClient.setId_internalClient(ID);
        return internalClientServiceInstance.updateInternalClient(internalClient);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteInternalClient(@PathVariable Long ID){
        internalClientServiceInstance.deleteInternalClient(ID);
        return ResponseEntity.noContent().build();
    }
}
