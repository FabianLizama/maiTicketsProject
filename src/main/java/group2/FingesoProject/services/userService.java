package group2.FingesoProject.services;

import group2.FingesoProject.entitites.userEntity;
import group2.FingesoProject.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {
    @Autowired
    private final userRepository userRepository;

    //Call service
    public userService(userRepository userRepository){
        this.userRepository = userRepository;
    }

    //CREATE
    public userEntity createUser(userEntity user){
        return userRepository.save(user);
    }

    //READ
    public List<userEntity> getAllUsers() {
        return userRepository.findAll();
    }

    //READbyID
    public Optional<userEntity> getUserById(Long ID){
        return userRepository.findById(ID);
    }

    //UPDATE
    public userEntity updateUser(userEntity user){
        return userRepository.save(user);
    }

    //DELETE(ID)x
    public void deleteUser(Long ID){
        userRepository.deleteById(ID);
    }
}
