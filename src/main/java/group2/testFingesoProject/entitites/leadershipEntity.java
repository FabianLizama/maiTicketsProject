package group2.testFingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "leadership")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class leadershipEntity {
    @ManyToOne
    @JoinColumn (name = "academicunit")
    private academicunitEntity academicunitEntity;

    @OneToMany (mappedBy = "leadership", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;



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
