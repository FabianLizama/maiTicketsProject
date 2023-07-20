package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yoandroide.persona.entities.AcademicUnit;
import xyz.yoandroide.persona.entities.Leadership;
import xyz.yoandroide.persona.repositories.AcademicUnitRepository;
import xyz.yoandroide.persona.services.AcademicUnitService;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/units/")
public class AcademicUnitController {
    @Autowired
    private AcademicUnitService academicUnitService;
    private final AcademicUnitRepository AcademicUnitRespository;

    public AcademicUnitController(AcademicUnitRepository academicUnitRespository) {
        this.AcademicUnitRespository = academicUnitRespository;
    }

    @GetMapping
    private ResponseEntity<List<AcademicUnit>> getAllAcademicUnits() {
        return ResponseEntity.ok(this.AcademicUnitRespository.findAll());
    }

    @GetMapping("/{idAcademicUnit}")
    private ResponseEntity<Optional<AcademicUnit>> getIdAcademicUnit(@PathVariable Long idAcademicUnit){
        return ResponseEntity.ok(academicUnitService.findById(idAcademicUnit));
    }

    @GetMapping("/{nameAcademicUnit}")
    private ResponseEntity<AcademicUnit> getIdAcademicUnit(@PathVariable String nameAcademicUnit){
        return ResponseEntity.ok(academicUnitService.findByName(nameAcademicUnit));
    }

    @PostMapping
    private ResponseEntity<AcademicUnit> saveUnits(@RequestBody AcademicUnit academicUnit) {
        try {
            AcademicUnit savedAcademicUnit = academicUnitService.save(academicUnit);
            return ResponseEntity.created(new URI("/units/"+savedAcademicUnit.getIdAcademicUnit())).body(savedAcademicUnit);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ("id") Long id) {
        academicUnitService.delete(id);
        return ResponseEntity.ok(!academicUnitService.existById(id));
    }

    @PutMapping("/leaderships/{idLeadership}/tickets/{idTicket}")
    public Leadership assignTicketToLeadership (
            @PathVariable Long idLeadership,
            @PathVariable Long idTicket) {
        return academicUnitService.assignTicketToLeadership(idLeadership, idTicket);
    }


}
