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

    @ManyToOne
    @JoinColumn (name = "ticketcategory")
    private ticketcategoryEntity ticketcategoryEntity;

    @ManyToOne
    @JoinColumn (name = "ticketrating")
    private ticketratingEntity ticketratingEntity;

    @ManyToOne
    @JoinColumn (name = "ticketpriority")
    private ticketpriorityEntity ticketpriorityEntity;

    @ManyToOne
    @JoinColumn (name = "ticketstate")
    private ticketstateEntity ticketstateEntity;

    @OneToMany (mappedBy = "ticketcomentary", cascade = CascadeType.ALL)
    private List<ticketcomentaryEntity> ticketcomentaryEntities;

    @OneToMany (mappedBy = "ticketdocument", cascade = CascadeType.ALL)
    private List<ticketdocumentEntity> ticketdocumentEntities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tickethistory")
    private tickethistoryEntity tickethistoryEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticketreport")
    private ticketreportEntity ticketreportEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_ticket;
    Date ticket_creation;
    Date ticket_limit;
    String description;
}
