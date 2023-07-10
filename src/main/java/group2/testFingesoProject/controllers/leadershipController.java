package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.leadershipEntity;
import group2.testFingesoProject.services.leadershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class leadershipController {
    @Autowired
    leadershipService leadershipServiceInstance;
    @PostMapping(value = "/leadership/")
    public ResponseEntity<leadershipEntity> save(@RequestBody leadershipEntity newLeadershipEntity){
        leadershipEntity object = leadershipServiceInstance.createLeadership(newLeadershipEntity);
        return new ResponseEntity<leadershipEntity>(object, HttpStatus.OK);
    }

}
