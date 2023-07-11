package group2.FingesoProject.services;

import group2.FingesoProject.entitites.academicunitEntity;
import group2.FingesoProject.repositories.academicunitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class academicunitService {
    @Autowired
    private final academicunitRepository academicunitRepository;

    //Call service
    public academicunitService(academicunitRepository academicunitRepository){
        this.academicunitRepository = academicunitRepository;
    }

    //CREATE
    public academicunitEntity createAcademicunit(academicunitEntity academicunit){
        return academicunitRepository.save(academicunit);
    }

    //READ
    public List<academicunitEntity> getAllAcademicunits() {
        return academicunitRepository.findAll();
    }

    //READbyID
    public Optional<academicunitEntity> getAcademicunitById(Long ID){
        return academicunitRepository.findById(ID);
    }

    //UPDATE
    public academicunitEntity updateAcademicunit(academicunitEntity academicunit){
        return academicunitRepository.save(academicunit);
    }

    //DELETE(ID)x
    public void deleteAcademicunit(Long ID){
        academicunitRepository.deleteById(ID);
    }
}
