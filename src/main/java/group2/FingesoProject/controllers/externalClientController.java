package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Externalclient")
public class externalClientController {
    @Autowired
    private final externalClientService externalClientServiceInstance;

    public externalClientController(externalClientService externalClientService){
        this.externalClientServiceInstance = externalClientService;
    }

    //CREATE
    @PostMapping
    public externalClientEntity createExternalclient(@RequestBody externalClientEntity externalClient){
        return externalClientServiceInstance.createExternalclient(externalClient);
    }

    //READ(ALL)
    @GetMapping
    public List<externalClientEntity> getAllExternalclients(){
        return externalClientServiceInstance.getAllExternalclients();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<externalClientEntity> getExternalclientByID(@PathVariable Long ID){
        Optional<externalClientEntity> externalClient = externalClientServiceInstance.getExternalclientById(ID);
        return externalClient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public externalClientEntity updateExternalclient(@PathVariable Long ID, @RequestBody externalClientEntity externalClient){
        externalClient.setId_externalClient(ID);
        return externalClientServiceInstance.updateExternalclient(externalClient);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteExternalclient(@PathVariable Long ID){
        externalClientServiceInstance.deleteExternalclient(ID);
        return ResponseEntity.noContent().build();
    }
}
