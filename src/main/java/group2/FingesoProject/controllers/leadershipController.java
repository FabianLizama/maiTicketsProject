package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.leadershipEntity;
import group2.FingesoProject.services.leadershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leadership")
public class leadershipController {
    @Autowired
    private final leadershipService leadershipServiceInstance;

    public leadershipController(leadershipService leadershipService){
        this.leadershipServiceInstance = leadershipService;
    }

    //CREATE
    @PostMapping
    public leadershipEntity createLeadership(@RequestBody leadershipEntity leadership){
        return leadershipServiceInstance.createLeadership(leadership);
    }

    //READ(ALL)
    @GetMapping
    public List<leadershipEntity> getAllLeaderships(){
        return leadershipServiceInstance.getAllLeaderships();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<leadershipEntity> getLeadershipByID(@PathVariable Long ID){
        Optional<leadershipEntity> leadership = leadershipServiceInstance.getleadershipById(ID);
        return leadership.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public leadershipEntity updateLeadership(@PathVariable Long ID, @RequestBody leadershipEntity leadership){
        leadership.setId_leadership(ID);
        return leadershipServiceInstance.updateLeadership(leadership);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteLeadership(@PathVariable Long ID){
        leadershipServiceInstance.deleteLeadership(ID);
        return ResponseEntity.noContent().build();
    }
}
