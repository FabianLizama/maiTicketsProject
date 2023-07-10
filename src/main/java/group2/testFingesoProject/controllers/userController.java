package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.userEntity;
import group2.testFingesoProject.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @Autowired
    userService userServiceInstance;
    @PostMapping(value = "/user/")
    public ResponseEntity<userEntity> save(@RequestBody userEntity newUserEntity){
        userEntity object = userServiceInstance.createUser(newUserEntity);
        return new ResponseEntity<userEntity>(object, HttpStatus.OK);
    }

}
