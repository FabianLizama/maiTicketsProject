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
    @JoinColumn(name = "id_ticketcategory")
    private ticketCategoryEntity ticketCategory;

    @ManyToOne
    @JoinColumn(name = "id_ticketrating")
    private ticketRatingEntity ticketRating;

    @ManyToOne
    @JoinColumn(name = "id_ticketpriority")
    private ticketPriorityEntity ticketPriority;

    @ManyToOne
    @JoinColumn(name = "id_ticketstate")
    private ticketStateEntity ticketState;

    @OneToMany(mappedBy = "ticket")
    private List<ticketComentaryEntity> ticketComentaries;

    @OneToMany(mappedBy = "ticket")
    private List<ticketDocumentEntity> ticketDocuments;

    @OneToMany(mappedBy = "ticket")
    private List<ticketHistoryEntity> ticketHistories;

    @OneToOne(mappedBy = "ticket")
    private ticketReportEntity ticketReport;

}
