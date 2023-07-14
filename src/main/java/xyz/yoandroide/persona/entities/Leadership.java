package xyz.yoandroide.persona.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Leadership")
public class Leadership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLeadership;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLeadership", referencedColumnName = "idLeadership")
    private List<Ticket> tickets;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLeadership", referencedColumnName = "idLeadership")
    private List<Analyzer> analyzers;

    @OneToOne
    @JoinColumn(name = "idAcademicUnit", referencedColumnName = "idAcademicUnit")
    private AcademicUnit academicUnit;
}
