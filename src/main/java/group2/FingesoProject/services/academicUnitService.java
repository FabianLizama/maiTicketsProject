package group2.FingesoProject.services;

import group2.FingesoProject.entitites.academicUnitEntity;
import group2.FingesoProject.repositories.academicUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class academicUnitService {
    @Autowired
    private final academicUnitRepository academicunitRepository;

    //Call service
    public academicUnitService(academicUnitRepository academicunitRepository){
        this.academicunitRepository = academicunitRepository;
    }

    //CREATE
    public academicUnitEntity createAcademicunit(academicUnitEntity academicunit){
        return academicunitRepository.save(academicunit);
    }

    //READ
    public List<academicUnitEntity> getAllAcademicunits() {
        return academicunitRepository.findAll();
    }

    //READbyID
    public Optional<academicUnitEntity> getAcademicunitById(Long ID){
        return academicunitRepository.findById(ID);
    }

    //UPDATE
    public academicUnitEntity updateAcademicunit(academicUnitEntity academicunit){
        return academicunitRepository.save(academicunit);
    }

    //DELETE(ID)x
    public void deleteAcademicunit(Long ID){
        academicunitRepository.deleteById(ID);
    }
}
