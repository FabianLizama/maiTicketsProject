package group2.testFingesoProject.services;

import group2.testFingesoProject.entitites.analyzerEntity;
import group2.testFingesoProject.repositories.analyzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class analyzerService {
    @Autowired
    analyzerRepository analyzerRepositoryInstance;
    public analyzerEntity createAnalyzer(analyzerEntity newAnalyzer) {
        //student validation
        return analyzerRepositoryInstance.save(newAnalyzer);
    }
}
