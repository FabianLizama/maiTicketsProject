package group2.testFingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ticketrating")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ticketratingEntity {

    @OneToMany (mappedBy = "ticketrating", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;
    Integer rating;
    boolean state;
}
