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
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAnalyzer", referencedColumnName = "idAnalyzer")
    private List<Ticket> tickets;
}
