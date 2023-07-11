package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.externalclientEntity;
import group2.FingesoProject.services.externalclientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/externalclient")
public class externalclientController {
    @Autowired
    private final externalclientService externalclientServiceInstance;

    public externalclientController(externalclientService externalclientService){
        this.externalclientServiceInstance = externalclientService;
    }

    //CREATE
    @PostMapping
    public externalclientEntity createExternalclient(@RequestBody externalclientEntity externalclient){
        return externalclientServiceInstance.createExternalclient(externalclient);
    }

    //READ(ALL)
    @GetMapping
    public List<externalclientEntity> getAllExternalclients(){
        return externalclientServiceInstance.getAllExternalclients();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<externalclientEntity> getExternalclientByID(@PathVariable Long ID){
        Optional<externalclientEntity> externalclient = externalclientServiceInstance.getExternalclientById(ID);
        return externalclient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public externalclientEntity updateExternalclient(@PathVariable Long ID, @RequestBody externalclientEntity externalclient){
        externalclient.setId_externalclient(ID);
        return externalclientServiceInstance.updateExternalclient(externalclient);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteExternalclient(@PathVariable Long ID){
        externalclientServiceInstance.deleteExternalclient(ID);
        return ResponseEntity.noContent().build();
    }
}
