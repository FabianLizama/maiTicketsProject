package group2.FingesoProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TicketPriority")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ticketPriorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_ticketPriority;

    private Integer Priority_level;

    @ManyToOne
    @JoinColumn(name = "id_ticket")
    private ticketEntity ticket;
}
