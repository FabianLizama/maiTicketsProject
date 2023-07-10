package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.userEntity;
import group2.testFingesoProject.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    userRepository userRepositoryInstance;
    public userEntity createUser(userEntity newUser) {
        //student validation
        return userRepositoryInstance.save(newUser);
    }
}
