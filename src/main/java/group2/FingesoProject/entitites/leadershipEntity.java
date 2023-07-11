package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Leadership")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class leadershipEntity extends userEntity{
    @ManyToOne
    @JoinColumn (name = "Academicunit")
    private academicunitEntity academicunitEntity;

    @OneToMany (mappedBy = "Leadership", cascade = CascadeType.ALL)
    private List<analyzerEntity> analyzerEntities;

    @OneToMany (mappedBy = "Leadership", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_leadership;
}
