package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.userInfoEntity;
import group2.FingesoProject.services.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User_info")
public class userInfoController {
    @Autowired
    private final userInfoService user_infoServiceInstance;

    public userInfoController(userInfoService user_infoService){
        this.user_infoServiceInstance = user_infoService;
    }

    //CREATE
    @PostMapping
    public userInfoEntity createUser_info(@RequestBody userInfoEntity user_info){
        return user_infoServiceInstance.createUser_info(user_info);
    }

    //READ(ALL)
    @GetMapping
    public List<userInfoEntity> getAllUser_infos(){
        return user_infoServiceInstance.getAllUser_infos();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<userInfoEntity> getUser_infoByID(@PathVariable Long ID){
        Optional<userInfoEntity> user_info = user_infoServiceInstance.getUser_infoById(ID);
        return user_info.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public userInfoEntity updateUser_info(@PathVariable Long ID, @RequestBody userInfoEntity user_info){
        user_info.setId_user_info(ID);
        return user_infoServiceInstance.updateUser_info(user_info);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteUser_info(@PathVariable Long ID){
        user_infoServiceInstance.deleteUser_info(ID);
        return ResponseEntity.noContent().build();
    }
}
