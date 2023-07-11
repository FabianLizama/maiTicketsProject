package group2.FingesoProject.services;

import group2.FingesoProject.entitites.user_infoEntity;
import group2.FingesoProject.repositories.user_infoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class user_infoService {
    @Autowired
    private final user_infoRepository user_infoRepository;

    //Call service
    public user_infoService(user_infoRepository user_infoRepository){
        this.user_infoRepository = user_infoRepository;
    }

    //CREATE
    public user_infoEntity createUser_info(user_infoEntity user_info){
        return user_infoRepository.save(user_info);
    }

    //READ
    public List<user_infoEntity> getAllUser_infos() {
        return user_infoRepository.findAll();
    }

    //READbyID
    public Optional<user_infoEntity> getUser_infoById(Long ID){
        return user_infoRepository.findById(ID);
    }

    //UPDATE
    public user_infoEntity updateUser_info(user_infoEntity user_info){
        return user_infoRepository.save(user_info);
    }

    //DELETE(ID)x
    public void deleteUser_info(Long ID){
        user_infoRepository.deleteById(ID);
    }
}
