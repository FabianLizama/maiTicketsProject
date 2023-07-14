package xyz.yoandroide.persona.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "AcademicUnit")
public class AcademicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAcademicUnit;
    private String name;

    @OneToOne(mappedBy = "AcademicUnit")
    private Leadership leadership;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAcademicUnit", referencedColumnName = "idAnalyzer")
    private List<Analyzer> analyzerList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAcademicUnit", referencedColumnName = "idTicket")
    private List<Ticket> ticketList;

}
