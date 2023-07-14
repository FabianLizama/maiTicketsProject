package xyz.yoandroide.persona.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTicket;

    private String description;

    private String category;

    private Integer priority;

    private String state;

    private Date creation;

    private Date responseLimit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLeadership", referencedColumnName = "idLeadership")
    private Leadership leadership;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAnalyzer", referencedColumnName = "idAnalyzer")
    private Analyzer analyzer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAcademicUnit", referencedColumnName = "idAcademicUnit")
    private AcademicUnit academicUnit;
}
