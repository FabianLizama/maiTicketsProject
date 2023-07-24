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

    @OneToOne
    @JoinColumn(name = "idLeadership", referencedColumnName = "idLeadership")
    private Leadership leadership;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAcademicUnit", referencedColumnName = "idAcademicUnit")
    private List<Ticket> tickets;

}
