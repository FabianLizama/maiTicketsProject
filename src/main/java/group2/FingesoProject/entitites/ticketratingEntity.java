package group2.FingesoProject.entitites;

import group2.FingesoProject.entitites.ticketEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticketrating")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ticketratingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_ticketrating;

    private Integer rating;

    private String rating_description;

    @ManyToOne
    @JoinColumn(name = "id_ticket")
    private ticketEntity ticket;
}
