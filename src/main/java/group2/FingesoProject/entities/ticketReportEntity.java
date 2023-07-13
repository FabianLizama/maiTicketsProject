package group2.FingesoProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ticketReport")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ticketReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_ticketReport;

    private String ticket_answer;

    private Date answer_date;

    @OneToOne
    @JoinColumn(name = "id_ticket")
    private ticketEntity ticket;
}
