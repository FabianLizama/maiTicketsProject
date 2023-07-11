package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Analyzer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class analyzerEntity extends  userEntity {
    @ManyToOne
    @JoinColumn (name = "Academicunit")
    private academicunitEntity academicunitEntity;

    @ManyToOne
    @JoinColumn (name = "Leadership")
    private leadershipEntity leadershipEntity;

    @OneToMany (mappedBy = "Analyzer", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_analyzer;

}
