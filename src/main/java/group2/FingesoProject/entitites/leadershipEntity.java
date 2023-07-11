package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Leadership")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class leadershipEntity extends user_infoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_leadership;

    @ManyToOne
    @JoinColumn(name = "id_analyzer")
    private analyzerEntity analyzer;

    @ManyToOne
    @JoinColumn(name = "id_academicunit")
    private academicunitEntity academicunit;

    // Getter and Setter methods (omitted for brevity)
}
