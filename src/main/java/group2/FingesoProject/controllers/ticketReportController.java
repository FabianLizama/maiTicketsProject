package group2.FingesoProject.controllers;

import group2.FingesoProject.entitites.ticketReportEntity;
import group2.FingesoProject.services.ticketReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticketreport")
public class ticketReportController {
    @Autowired
    private final ticketReportService ticketreportServiceInstance;

    public ticketReportController(ticketReportService ticketreportService){
        this.ticketreportServiceInstance = ticketreportService;
    }

    //CREATE
    @PostMapping
    public ticketReportEntity createTicketreport(@RequestBody ticketReportEntity ticketreport){
        return ticketreportServiceInstance.createTicketreport(ticketreport);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketReportEntity> getAllTicketreports(){
        return ticketreportServiceInstance.getAllTicketreports();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketReportEntity> getticketreportByID(@PathVariable Long ID){
        Optional<ticketReportEntity> ticketreport = ticketreportServiceInstance.getTicketreportById(ID);
        return ticketreport.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketReportEntity updateTicketreport(@PathVariable Long ID, @RequestBody ticketReportEntity ticketreport){
        ticketreport.setId_ticketreport(ID);
        return ticketreportServiceInstance.updateTicketreport(ticketreport);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketreport(@PathVariable Long ID){
        ticketreportServiceInstance.deleteTicketreport(ID);
        return ResponseEntity.noContent().build();
    }
}
