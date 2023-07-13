package group2.FingesoProject.services;

import group2.FingesoProject.entities.userInfoEntity;
import group2.FingesoProject.repositories.userInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userInfoService {
    @Autowired
    private final userInfoRepository user_infoRepository;

    //Call service
    public userInfoService(userInfoRepository user_infoRepository){
        this.user_infoRepository = user_infoRepository;
    }

    //CREATE
    public userInfoEntity createUser_info(userInfoEntity user_info){
        return user_infoRepository.save(user_info);
    }

    //READ
    public List<userInfoEntity> getAllUser_infos() {
        return user_infoRepository.findAll();
    }

    //READbyID
    public Optional<userInfoEntity> getUser_infoById(Long ID){
        return user_infoRepository.findById(ID);
    }

    //UPDATE
    public userInfoEntity updateUser_info(userInfoEntity user_info){
        return user_infoRepository.save(user_info);
    }

    //DELETE(ID)x
    public void deleteUser_info(Long ID){
        user_infoRepository.deleteById(ID);
    }
}
