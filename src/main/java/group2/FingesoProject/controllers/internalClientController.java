package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.internalClientEntity;
import group2.FingesoProject.services.internalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Internalclient")
public class internalClientController {
    @Autowired
    private final internalClientService internalClientServiceInstance;

    public internalClientController(internalClientService internalClientService){
        this.internalClientServiceInstance = internalClientService;
    }

    //CREATE
    @PostMapping
    public internalClientEntity createInternalclient(@RequestBody internalClientEntity internalClient){
        return internalClientServiceInstance.createInternalclient(internalClient);
    }

    //READ(ALL)
    @GetMapping
    public List<internalClientEntity> getAllInternalclients(){
        return internalClientServiceInstance.getAllInternalclients();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<internalClientEntity> getInternalclientByID(@PathVariable Long ID){
        Optional<internalClientEntity> internalClient = internalClientServiceInstance.getInternalClientById(ID);
        return internalClient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public internalClientEntity updateInternalclient(@PathVariable Long ID, @RequestBody internalClientEntity internalClient){
        internalClient.setId_internalClient(ID);
        return internalClientServiceInstance.updateInternalclient(internalClient);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteInternalclient(@PathVariable Long ID){
        internalClientServiceInstance.deleteInternalclient(ID);
        return ResponseEntity.noContent().build();
    }
}
