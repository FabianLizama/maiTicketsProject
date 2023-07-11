package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketreportEntity;
import group2.FingesoProject.services.ticketreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticketreport")
public class ticketreportController {
    @Autowired
    private final ticketreportService ticketreportServiceInstance;

    public ticketreportController(ticketreportService ticketreportService){
        this.ticketreportServiceInstance = ticketreportService;
    }

    //CREATE
    @PostMapping
    public ticketreportEntity createTicketreport(@RequestBody ticketreportEntity ticketreport){
        return ticketreportServiceInstance.createTicketreport(ticketreport);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketreportEntity> getAllTicketreports(){
        return ticketreportServiceInstance.getAllTicketreports();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketreportEntity> getticketreportByID(@PathVariable Long ID){
        Optional<ticketreportEntity> ticketreport = ticketreportServiceInstance.getTicketreportById(ID);
        return ticketreport.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketreportEntity updateTicketreport(@PathVariable Long ID, @RequestBody ticketreportEntity ticketreport){
        ticketreport.setId_ticketreport(ID);
        return ticketreportServiceInstance.updateTicketreport(ticketreport);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketreport(@PathVariable Long ID){
        ticketreportServiceInstance.deleteTicketreport(ID);
        return ResponseEntity.noContent().build();
    }
}
