package group2.testFingesoProject.controllers;

import group2.testFingesoProject.entitites.analyzerEntity;
import group2.testFingesoProject.services.analyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class analyzerController {
    @Autowired
    analyzerService analyzerServiceInstance;
    @PostMapping(value = "/analyzer/")
    public ResponseEntity<analyzerEntity> save(@RequestBody analyzerEntity newAnalyzerEntity){
        analyzerEntity object = analyzerServiceInstance.createAnalyzer(newAnalyzerEntity);
        return new ResponseEntity<analyzerEntity>(object, HttpStatus.OK);
    }

}
