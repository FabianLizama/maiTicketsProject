package group2.testFingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ticketpriority")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ticketpriorityEntity {

    @OneToMany (mappedBy = "ticketpriority", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;
    Integer priority;
    boolean state;
}
