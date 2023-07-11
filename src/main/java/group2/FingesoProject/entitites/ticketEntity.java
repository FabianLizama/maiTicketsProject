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
    @JoinColumn (name = "Ticketcategory")
    private ticketcategoryEntity ticketcategoryEntity;

    @ManyToOne
    @JoinColumn (name = "Ticketrating")
    private ticketratingEntity ticketratingEntity;

    @ManyToOne
    @JoinColumn (name = "Ticketpriority")
    private ticketpriorityEntity ticketpriorityEntity;

    @ManyToOne
    @JoinColumn (name = "Ticketstate")
    private ticketstateEntity ticketstateEntity;

    @OneToMany (mappedBy = "Ticketcomentary", cascade = CascadeType.ALL)
    private List<ticketcomentaryEntity> ticketcomentaryEntities;

    @OneToMany (mappedBy = "Ticketdocument", cascade = CascadeType.ALL)
    private List<ticketdocumentEntity> ticketdocumentEntities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Tickethistory")
    private tickethistoryEntity tickethistoryEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Ticketreport")
    private ticketreportEntity ticketreportEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_ticket;
    Date ticket_creation;
    Date ticket_limit;
    String description;
}
