package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "ticketcomentary")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ticketcomentaryEntity {

    @ManyToOne
    @JoinColumn (name = "ticket")
    private ticketEntity ticketEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_ticketcomentary;
    String comentary;
    Date creation_comentary_date;
    Time creation_comentary_hour;
}


