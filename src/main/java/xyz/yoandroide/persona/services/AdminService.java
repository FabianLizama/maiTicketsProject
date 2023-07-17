package xyz.yoandroide.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yoandroide.persona.entities.*;
import xyz.yoandroide.persona.repositories.AcademicUnitRepository;
import xyz.yoandroide.persona.repositories.AdminRepository;
import xyz.yoandroide.persona.repositories.AnalyzerRepository;
import xyz.yoandroide.persona.repositories.LeadershipRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private LeadershipRepository leadershipRepository;

    @Autowired
    private AcademicUnitRepository academicUnitRepository;

    @Autowired
    private AnalyzerRepository analyzerRepository;

    public <S extends Admin> S save(S entity) {
        return adminRepository.save(entity);
    }
    public Optional<Admin> findById(Long aLong) {
        return adminRepository.findById(aLong);
    }
    public void delete(Long id) { adminRepository.deleteById(id); }

    public boolean existById(Long id) {return adminRepository.existsById(id); }
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }
    public long count() {
        return adminRepository.count();
    }

    public AcademicUnit assignLeadershipToAcademicUnit(Long idLeadership, Long idAcademicUnit) {
        Leadership leadership = leadershipRepository.findById(idLeadership).get();
        AcademicUnit academicUnit = academicUnitRepository.findById(idAcademicUnit).get();
        academicUnit.setLeadership(leadership);
        return academicUnitRepository.save(academicUnit);
    }

    public Leadership assignAnalyzerToLeadership(Long idLeadership, Long idAnalyzer) {
        List<Analyzer> analyzerList = null;
        Leadership leadership = leadershipRepository.findById(idLeadership).get();
        Analyzer analyzer = analyzerRepository.findById(idAnalyzer).get();
        analyzerList = leadership.getAnalyzers();
        analyzerList.add(analyzer);
        leadership.setAnalyzers(analyzerList);
        return leadershipRepository.save(leadership);
    }
}
