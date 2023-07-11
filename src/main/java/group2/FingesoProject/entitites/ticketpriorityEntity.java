package group2.FingesoProject.entitites;

import group2.FingesoProject.entitites.ticketEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticketpriority")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ticketpriorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_ticketpriority;

    private Integer priority_level;

    @ManyToOne
    @JoinColumn(name = "id_ticket")
    private ticketEntity ticket;
}
