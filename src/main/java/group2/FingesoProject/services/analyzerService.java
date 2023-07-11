package group2.FingesoProject.services;

import group2.FingesoProject.entitites.analyzerEntity;
import group2.FingesoProject.repositories.analyzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class analyzerService {
    @Autowired
    private final analyzerRepository analyzerRepository;

    //Call service
    public analyzerService(analyzerRepository analyzerRepository){
        this.analyzerRepository = analyzerRepository;
    }

    //CREATE
    public analyzerEntity createAnalyzer(analyzerEntity analyzer){
        return analyzerRepository.save(analyzer);
    }

    //READ
    public List<analyzerEntity> getAllAnalyzers() {
        return analyzerRepository.findAll();
    }

    //READbyID
    public Optional<analyzerEntity> getAnalyzerById(Long ID){
        return analyzerRepository.findById(ID);
    }

    //UPDATE
    public analyzerEntity updateAnalyzer(analyzerEntity analyzer){
        return analyzerRepository.save(analyzer);
    }

    //DELETE(ID)x
    public void deleteAnalyzer(Long ID){
        analyzerRepository.deleteById(ID);
    }
}
