package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.academicUnitEntity;
import group2.FingesoProject.services.academicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Academicunit")
public class academicUnitController {
    @Autowired
    private final academicUnitService academicunitServiceInstance;

    public academicUnitController(academicUnitService academicunitService){
        this.academicunitServiceInstance = academicunitService;
    }

    //CREATE
    @PostMapping
    public academicUnitEntity createAcademicunit(@RequestBody academicUnitEntity academicunit){
        return academicunitServiceInstance.createAcademicunit(academicunit);
    }

    //READ(ALL)
    @GetMapping
    public List<academicUnitEntity> getAllAcademicunits(){
        return academicunitServiceInstance.getAllAcademicunits();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<academicUnitEntity> getAcademicunitByID(@PathVariable Long ID){
        Optional<academicUnitEntity> academicunit = academicunitServiceInstance.getAcademicunitById(ID);
        return academicunit.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public academicUnitEntity updateAcademicunit(@PathVariable Long ID, @RequestBody academicUnitEntity academicunit){
        academicunit.setId_academicunit(ID);
        return academicunitServiceInstance.updateAcademicunit(academicunit);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteAcademicunit(@PathVariable Long ID){
        academicunitServiceInstance.deleteAcademicunit(ID);
        return ResponseEntity.noContent().build();
    }
}
