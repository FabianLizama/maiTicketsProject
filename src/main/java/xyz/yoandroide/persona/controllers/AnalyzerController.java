package xyz.yoandroide.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yoandroide.persona.entities.Analyzer;
import xyz.yoandroide.persona.services.AnalyzerService;

import java.util.List;

@RestController
@RequestMapping("/analyzers/")
public class AnalyzerController {
    @Autowired
    private AnalyzerService analyzerService;

    @GetMapping
    private ResponseEntity<List<Analyzer>> getAllAnalyzers(){
        return ResponseEntity.ok(analyzerService.findAll());
    }
}
