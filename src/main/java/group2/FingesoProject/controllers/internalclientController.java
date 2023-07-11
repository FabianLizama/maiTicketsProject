package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.internalclientEntity;
import group2.FingesoProject.services.internalclientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/internalclient")
public class internalclientController {
    @Autowired
    private final internalclientService internalclientServiceInstance;

    public internalclientController(internalclientService internalclientService){
        this.internalclientServiceInstance = internalclientService;
    }

    //CREATE
    @PostMapping
    public internalclientEntity createInternalclient(@RequestBody internalclientEntity internalclient){
        return internalclientServiceInstance.createInternalclient(internalclient);
    }

    //READ(ALL)
    @GetMapping
    public List<internalclientEntity> getAllInternalclients(){
        return internalclientServiceInstance.getAllInternalclients();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<internalclientEntity> getInternalclientByID(@PathVariable Long ID){
        Optional<internalclientEntity> internalclient = internalclientServiceInstance.getInternalclientById(ID);
        return internalclient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public internalclientEntity updateInternalclient(@PathVariable Long ID, @RequestBody internalclientEntity internalclient){
        internalclient.setId_internalclient(ID);
        return internalclientServiceInstance.updateInternalclient(internalclient);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteInternalclient(@PathVariable Long ID){
        internalclientServiceInstance.deleteInternalclient(ID);
        return ResponseEntity.noContent().build();
    }
}
