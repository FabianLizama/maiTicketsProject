package group2.testFingesoProject.entitites;

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
    Long id;
    String name;
    String lastname_p;
    String lastname_m;
    String rut;
    boolean state;
}
