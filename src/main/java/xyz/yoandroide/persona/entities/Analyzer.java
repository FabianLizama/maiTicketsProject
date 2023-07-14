package xyz.yoandroide.persona.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Analyzer")
public class Analyzer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnalyzer;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAnalyzer", referencedColumnName = "idAnalyzer")
    private List<Ticket> tickets;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLeadership", referencedColumnName = "idLeadership")
    private Leadership leadership;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAcademicUnit", referencedColumnName = "idAcademicUnit")
    private AcademicUnit academicUnit;
}
