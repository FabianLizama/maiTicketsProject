package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.externalClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ExternalClient")
public class externalClientController {
    @Autowired
    private final externalClientService externalClientServiceInstance;

    public externalClientController(externalClientService externalClientService){
        this.externalClientServiceInstance = externalClientService;
    }

    //CREATE
    @PostMapping
    public externalClientEntity createExternalClient(@RequestBody externalClientEntity externalClient){
        return externalClientServiceInstance.createExternalClient(externalClient);
    }

    //READ(ALL)
    @GetMapping
    public List<externalClientEntity> getAllExternalClients(){
        return externalClientServiceInstance.getAllExternalClients();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<externalClientEntity> getExternalClientByID(@PathVariable Long ID){
        Optional<externalClientEntity> externalClient = externalClientServiceInstance.getExternalClientById(ID);
        return externalClient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public externalClientEntity updateExternalClient(@PathVariable Long ID, @RequestBody externalClientEntity externalClient){
        externalClient.setId_externalClient(ID);
        return externalClientServiceInstance.updateExternalClient(externalClient);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteExternalClient(@PathVariable Long ID){
        externalClientServiceInstance.deleteExternalClient(ID);
        return ResponseEntity.noContent().build();
    }
}
