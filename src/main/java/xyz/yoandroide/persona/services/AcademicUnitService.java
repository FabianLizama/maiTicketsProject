package xyz.yoandroide.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yoandroide.persona.entities.AcademicUnit;
import xyz.yoandroide.persona.entities.Client;
import xyz.yoandroide.persona.entities.Leadership;
import xyz.yoandroide.persona.entities.Ticket;
import xyz.yoandroide.persona.repositories.AcademicUnitRepository;
import xyz.yoandroide.persona.repositories.ClientRepository;
import xyz.yoandroide.persona.repositories.LeadershipRepository;
import xyz.yoandroide.persona.repositories.TicketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AcademicUnitService {
    @Autowired
    private AcademicUnitRepository academicUnitRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private LeadershipRepository leadershipRepository;

    public <S extends AcademicUnit> S save(S entity) {
        return academicUnitRepository.save(entity);
    }


    public Optional<AcademicUnit> findById(Long aLong) {
        return academicUnitRepository.findById(aLong);
    }

    public void delete(Long id) { academicUnitRepository.deleteById(id); }

    public boolean existById(Long id) {return academicUnitRepository.existsById(id); }

    public Long findLeadershipById(Long aLong) {
        return academicUnitRepository.findById(aLong).get().getLeadership().getIdLeadership();
    }

    public List<AcademicUnit> findAll() {
        return academicUnitRepository.findAll();
    }

    public long count() {
        return academicUnitRepository.count();
    }


    public Leadership assignTicketToLeadership(Long idLeadership, Long idTicket) {
        List<Ticket> ticketList = null;
        Leadership leadership = leadershipRepository.findById(idLeadership).get();
        Ticket ticket = ticketRepository.findById(idTicket).get();
        ticket.setFkIdLeadership(idLeadership);
        ticketList = leadership.getTickets();
        ticketList.add(ticket);
        leadership.setTickets(ticketList);
        return leadershipRepository.save(leadership);
    }

    public Long findByName(String nameAcademicUnit){
        List<AcademicUnit> academicUnits = academicUnitRepository.findAll();

        for(AcademicUnit academicUnit : academicUnits){
            if(academicUnit.getName().equals(nameAcademicUnit)){
                return academicUnit.getIdAcademicUnit();
            }
        }
        return null;
    }

    public List<String> findUnitNames(){
        List<String> names = new ArrayList<>();
        List<AcademicUnit> units = academicUnitRepository.findAll();

        for(AcademicUnit academicUnit : units){
            names.add(academicUnit.getName());
        }

        return names;
    }
}
