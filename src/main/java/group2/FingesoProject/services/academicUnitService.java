package group2.FingesoProject.services;

import group2.FingesoProject.entities.academicUnitEntity;
import group2.FingesoProject.repositories.academicUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class academicUnitService {
    @Autowired
    private final academicUnitRepository academicUnitRepository;

    //Call service
    public academicUnitService(academicUnitRepository academicUnitRepository){
        this.academicUnitRepository = academicUnitRepository;
    }

    //CREATE
    public academicUnitEntity createAcademicUnit(academicUnitEntity academicUnit){
        return academicUnitRepository.save(academicUnit);
    }

    //READ
    public List<academicUnitEntity> getAllAcademicUnits() {
        return academicUnitRepository.findAll();
    }

    //READbyID
    public Optional<academicUnitEntity> getAcademicUnitById(Long ID){
        return academicUnitRepository.findById(ID);
    }

    //UPDATE
    public academicUnitEntity updateAcademicUnit(academicUnitEntity academicUnit){
        return academicunitRepository.save(academicUnit);
    }

    //DELETE(ID)x
    public void deleteAcademicUnit(Long ID){
        academicUnitRepository.deleteById(ID);
    }
}
