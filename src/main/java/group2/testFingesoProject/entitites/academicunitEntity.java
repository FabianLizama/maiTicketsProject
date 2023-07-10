package group2.testFingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "academicunit")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class academicunitEntity {
    @OneToMany (mappedBy = "academicunit", cascade = CascadeType.ALL)
    private List<leadershipEntity> leadershipEntities;

    @OneToMany (mappedBy = "academicunit", cascade = CascadeType.ALL)
    private List<analyzerEntity> analyzerEntities;

    @OneToMany (mappedBy = "academicunit", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;
    String name;
    boolean state;
}
