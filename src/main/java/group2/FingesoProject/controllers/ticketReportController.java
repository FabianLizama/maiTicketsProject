package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.ticketReportEntity;
import group2.FingesoProject.services.ticketReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TicketReport")
public class ticketReportController {
    @Autowired
    private final ticketReportService ticketReportServiceInstance;

    public ticketReportController(ticketReportService ticketReportService){
        this.ticketReportServiceInstance = ticketReportService;
    }

    //CREATE
    @PostMapping
    public ticketReportEntity createTicketReport(@RequestBody ticketReportEntity ticketReport){
        return ticketReportServiceInstance.createTicketReport(ticketReport);
    }

    //READ(ALL)
    @GetMapping
    public List<ticketReportEntity> getAllTicketReports(){
        return ticketReportServiceInstance.getAllTicketReports();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<ticketReportEntity> getticketReportByID(@PathVariable Long ID){
        Optional<ticketReportEntity> ticketReport = ticketReportServiceInstance.getTicketReportById(ID);
        return ticketReport.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public ticketReportEntity updateTicketReport(@PathVariable Long ID, @RequestBody ticketReportEntity ticketReport){
        ticketReport.setId_ticketReport(ID);
        return ticketReportServiceInstance.updateTicketReport(ticketReport);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteTicketReport(@PathVariable Long ID){
        ticketReportServiceInstance.deleteTicketReport(ID);
        return ResponseEntity.noContent().build();
    }
}
