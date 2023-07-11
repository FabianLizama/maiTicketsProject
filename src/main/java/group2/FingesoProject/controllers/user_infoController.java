package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.user_infoEntity;
import group2.FingesoProject.services.user_infoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User_info")
public class user_infoController {
    @Autowired
    private final user_infoService user_infoServiceInstance;

    public user_infoController(user_infoService user_infoService){
        this.user_infoServiceInstance = user_infoService;
    }

    //CREATE
    @PostMapping
    public user_infoEntity createUser_info(@RequestBody user_infoEntity user_info){
        return user_infoServiceInstance.createUser_info(user_info);
    }

    //READ(ALL)
    @GetMapping
    public List<user_infoEntity> getAllUser_infos(){
        return user_infoServiceInstance.getAllUser_infos();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<user_infoEntity> getUser_infoByID(@PathVariable Long ID){
        Optional<user_infoEntity> user_info = user_infoServiceInstance.getUser_infoById(ID);
        return user_info.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public user_infoEntity updateUser_info(@PathVariable Long ID, @RequestBody user_infoEntity user_info){
        user_info.setId_user_info(ID);
        return user_infoServiceInstance.updateUser_info(user_info);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteUser_info(@PathVariable Long ID){
        user_infoServiceInstance.deleteUser_info(ID);
        return ResponseEntity.noContent().build();
    }
}
