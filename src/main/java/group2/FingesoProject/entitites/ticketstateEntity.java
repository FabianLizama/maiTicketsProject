package group2.FingesoProject.entitites;

import group2.FingesoProject.entitites.ticketEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticketstate")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ticketstateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_ticketstate;

    private String state_name;

    @ManyToOne
    @JoinColumn(name = "id_ticket")
    private ticketEntity ticket;
}
