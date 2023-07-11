package group2.FingesoProject.entitites;

import group2.FingesoProject.entitites.ticketEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ticketreport")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ticketreportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_ticketreport;

    private String ticket_answer;

    private Date answer_date;

    @OneToOne
    @JoinColumn(name = "id_ticket")
    private ticketEntity ticket;
}
