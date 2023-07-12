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
    private final internalClientService internalclientServiceInstance;

    public internalClientController(internalClientService internalclientService){
        this.internalclientServiceInstance = internalclientService;
    }

    //CREATE
    @PostMapping
    public internalClientEntity createInternalclient(@RequestBody internalClientEntity internalclient){
        return internalclientServiceInstance.createInternalclient(internalclient);
    }

    //READ(ALL)
    @GetMapping
    public List<internalClientEntity> getAllInternalclients(){
        return internalclientServiceInstance.getAllInternalclients();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<internalClientEntity> getInternalclientByID(@PathVariable Long ID){
        Optional<internalClientEntity> internalclient = internalclientServiceInstance.getInternalclientById(ID);
        return internalclient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public internalClientEntity updateInternalclient(@PathVariable Long ID, @RequestBody internalClientEntity internalclient){
        internalclient.setId_internalclient(ID);
        return internalclientServiceInstance.updateInternalclient(internalclient);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteInternalclient(@PathVariable Long ID){
        internalclientServiceInstance.deleteInternalclient(ID);
        return ResponseEntity.noContent().build();
    }
}
