package xyz.yoandroide.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yoandroide.persona.entities.AcademicUnit;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.repositories.AcademicUnitRepository;
import xyz.yoandroide.persona.repositories.ClientRepository;
import xyz.yoandroide.persona.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicUnitService {
    @Autowired
    private AcademicUnitRepository academicUnitRepository;

    public <S extends AcademicUnit> S save(S entity) {
        return academicUnitRepository.save(entity);
    }


    public Optional<AcademicUnit> findById(Long aLong) {
        return academicUnitRepository.findById(aLong);
    }


    public List<AcademicUnit> findAll() {
        return academicUnitRepository.findAll();
    }

    public long count() {
        return academicUnitRepository.count();
    }
}
