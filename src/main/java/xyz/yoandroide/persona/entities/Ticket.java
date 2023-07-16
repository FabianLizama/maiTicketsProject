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
    private String answer;
    private Long fkIdClient;
    private Long fkIdAnalyzer;
    private Long fkIdAcademicUnit;
    private Long fkIdLeadership;
}
