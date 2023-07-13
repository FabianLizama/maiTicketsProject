package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.academicUnitEntity;
import group2.FingesoProject.services.academicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/academicUnit")
public class academicUnitController {
    @Autowired
    private final academicUnitService academicUnitServiceInstance;

    public academicUnitController(academicUnitService academicUnitService){
        this.academicUnitServiceInstance = academicUnitService;
    }

    //CREATE
    @PostMapping
    public academicUnitEntity createAcademicUnit(@RequestBody academicUnitEntity academicUnit){
        return academicUnitServiceInstance.createAcademicUnit(academicUnit);
    }

    //READ(ALL)
    @GetMapping
    public List<academicUnitEntity> getAllAcademicUnits(){
        return academicUnitServiceInstance.getAllAcademicUnits();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<academicUnitEntity> getAcademicUnitByID(@PathVariable Long ID){
        Optional<academicUnitEntity> academicUnit = academicUnitServiceInstance.getAcademicUnitById(ID);
        return academicUnit.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public academicUnitEntity updateAcademicUnit(@PathVariable Long ID, @RequestBody academicUnitEntity academicUnit){
        academicUnit.setId_academicUnit(ID);
        return academicUnitServiceInstance.updateAcademicUnit(academicUnit);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteAcademicUnit(@PathVariable Long ID){
        academicUnitServiceInstance.deleteAcademicUnit(ID);
        return ResponseEntity.noContent().build();
    }
}
