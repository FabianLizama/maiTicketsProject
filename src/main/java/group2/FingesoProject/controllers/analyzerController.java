package group2.FingesoProject.controllers;

import group2.FingesoProject.entities.analyzerEntity;
import group2.FingesoProject.services.analyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Analyzer")
public class analyzerController {
    @Autowired
    private final analyzerService analyzerServiceInstance;

    public analyzerController(analyzerService analyzerService){
        this.analyzerServiceInstance = analyzerService;
    }

    //CREATE
    @PostMapping
    public analyzerEntity createAnalyzer(@RequestBody analyzerEntity analyzer){
        return analyzerServiceInstance.createAnalyzer(analyzer);
    }

    //READ(ALL)
    @GetMapping
    public List<analyzerEntity> getAllAnalyzers(){
        return analyzerServiceInstance.getAllAnalyzers();
    }

    //READ(ID)
    @GetMapping("/{ID}")
    public ResponseEntity<analyzerEntity> getAnalyzerByID(@PathVariable Long ID){
        Optional<analyzerEntity> analyzer = analyzerServiceInstance.getAnalyzerById(ID);
        return analyzer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //UPDATE
    @PutMapping("/{ID}")
    public analyzerEntity updateAnalyzer(@PathVariable Long ID, @RequestBody analyzerEntity analyzer){
        analyzer.setId_analyzer(ID);
        return analyzerServiceInstance.updateAnalyzer(analyzer);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Void> deleteAnalyzer(@PathVariable Long ID){
        analyzerServiceInstance.deleteAnalyzer(ID);
        return ResponseEntity.noContent().build();
    }
}
