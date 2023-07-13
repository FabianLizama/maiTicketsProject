package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Ticket")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ticketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long idTicket;

    @Column(name = "ticket_creation")
    private Date ticketCreation;

    @Column(name = "ticket_limit")
    private Date ticketLimit;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_analyzer")
    private analyzerEntity analyzerEntity;

    @ManyToOne
    @JoinColumn(name = "id_leadership")
    private leadershipEntity leadershipEntity;

    @ManyToOne
    @JoinColumn(name = "id_academicUnit")
    private academicUnitEntity academicUnitEntity;

    @ManyToOne
    @JoinColumn(name = "id_internalClient")
    private internalClientEntity internalClientEntity;

    @ManyToOne
    @JoinColumn(name = "id_externalClient")
    private externalClientEntity externalClientEntity;


}
