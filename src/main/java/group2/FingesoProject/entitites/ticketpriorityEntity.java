package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Ticketpriority")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ticketpriorityEntity {

    @OneToMany (mappedBy = "Ticketpriority", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_ticketpriority;
    Integer priority_level;
}
