package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.externalClientEntity;
import group2.FingesoProject.services.externalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Externalclient")
public class externalClientController {
    @Autowired
    private final externalClientService externalclientServiceInstance;

    public externalClientController(externalClientService externalclientService){
        this.externalclientServiceInstance = externalclientService;
    }

    //CREATE
    @PostMapping
    public externalClientEntity createExternalclient(@RequestBody externalClientEntity externalclient){
        return externalclientServiceInstance.createExternalclient(externalclient);
    }

    //READ(ALL)
    @GetMapping
    public List<externalClientEntity> getAllExternalclients(){
        return externalclientServiceInstance.getAllExternalclients();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<externalClientEntity> getExternalclientByID(@PathVariable Long ID){
        Optional<externalClientEntity> externalclient = externalclientServiceInstance.getExternalclientById(ID);
        return externalclient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public externalClientEntity updateExternalclient(@PathVariable Long ID, @RequestBody externalClientEntity externalclient){
        externalclient.setId_externalclient(ID);
        return externalclientServiceInstance.updateExternalclient(externalclient);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteExternalclient(@PathVariable Long ID){
        externalclientServiceInstance.deleteExternalclient(ID);
        return ResponseEntity.noContent().build();
    }
}
