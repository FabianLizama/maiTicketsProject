package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Ticketcomentary")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ticketcomentaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_ticketcomentary;

    private String commentary;
    private Date creation_comentary_date;
    private Time creation_comentary_hour;

    @ManyToOne
    @JoinColumn(name = "id_ticket")
    private ticketEntity ticket;
}
