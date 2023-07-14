package xyz.yoandroide.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yoandroide.persona.entities.Analyzer;
import xyz.yoandroide.persona.repositories.AnalyzerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnalyzerService {
    @Autowired
    private AnalyzerRepository analyzerRepository;
    public <S extends Analyzer> S save(S entity) {
        return analyzerRepository.save(entity);
    }

    public Optional<Analyzer> findById(Long aLong) {
        return analyzerRepository.findById(aLong);
    }

    public List<Analyzer> findAll() {
        return analyzerRepository.findAll();
    }

    public long count() {
        return analyzerRepository.count();
    }
}
