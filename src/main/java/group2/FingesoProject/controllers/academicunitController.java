package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.academicunitEntity;
import group2.FingesoProject.services.academicunitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Academicunit")
public class academicunitController {
    @Autowired
    private final academicunitService academicunitServiceInstance;

    public academicunitController(academicunitService academicunitService){
        this.academicunitServiceInstance = academicunitService;
    }

    //CREATE
    @PostMapping
    public academicunitEntity createAcademicunit(@RequestBody academicunitEntity academicunit){
        return academicunitServiceInstance.createAcademicunit(academicunit);
    }

    //READ(ALL)
    @GetMapping
    public List<academicunitEntity> getAllAcademicunits(){
        return academicunitServiceInstance.getAllAcademicunits();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<academicunitEntity> getAcademicunitByID(@PathVariable Long ID){
        Optional<academicunitEntity> academicunit = academicunitServiceInstance.getAcademicunitById(ID);
        return academicunit.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public academicunitEntity updateAcademicunit(@PathVariable Long ID, @RequestBody academicunitEntity academicunit){
        academicunit.setId_academicunit(ID);
        return academicunitServiceInstance.updateAcademicunit(academicunit);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteAcademicunit(@PathVariable Long ID){
        academicunitServiceInstance.deleteAcademicunit(ID);
        return ResponseEntity.noContent().build();
    }
}
