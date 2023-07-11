package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.userEntity;
import group2.FingesoProject.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private final userService userServiceInstance;

    public userController(userService userService){
        this.userServiceInstance = userService;
    }

    //CREATE
    @PostMapping
    public userEntity createUser(@RequestBody userEntity user){
        return userServiceInstance.createUser(user);
    }

    //READ(ALL)
    @GetMapping
    public List<userEntity> getAllUsers(){
        return userServiceInstance.getAllUsers();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<userEntity> getUserByID(@PathVariable Long ID){
        Optional<userEntity> user = userServiceInstance.getuserById(ID);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public userEntity updateUser(@PathVariable Long ID, @RequestBody userEntity user){
        user.setId_user(ID);
        return userServiceInstance.updateUser(user);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteuser(@PathVariable Long ID){
        userServiceInstance.deleteUser(ID);
        return ResponseEntity.noContent().build();
    }
}
