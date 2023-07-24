package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yoandroide.persona.entities.*;
import xyz.yoandroide.persona.services.AdminService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admins/")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    private ResponseEntity<List<Admin>> getAllAdmins(){
        return ResponseEntity.ok(adminService.findAll());
    }

    @PostMapping
    private ResponseEntity<Admin> saveAnalyzer(@RequestBody Admin admin){
        try{
            Admin savedAdmin = adminService.save(admin);
            return ResponseEntity.created(new URI("/admins/"+savedAdmin.getIdAdmin())).body(savedAdmin);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ("id") Long id) {
        adminService.delete(id);
        return ResponseEntity.ok(!adminService.existById(id));
    }

    @PutMapping("/leaderships/{idLeadership}/units/{idAcademicUnit}")
    public AcademicUnit assignLeadershipToAcademicUnit (
            @PathVariable Long idLeadership,
            @PathVariable Long idAcademicUnit) {
        return adminService.assignLeadershipToAcademicUnit(idLeadership, idAcademicUnit);
    }

    @PutMapping("/analyzers/{idAnalyzer}/leaderships/{idLeadership}")
    public Leadership assignAnalyzerToLeadership (
            @PathVariable Long idLeadership,
            @PathVariable Long idAnalyzer) {
        return adminService.assignAnalyzerToLeadership(idLeadership, idAnalyzer);
    }

}
