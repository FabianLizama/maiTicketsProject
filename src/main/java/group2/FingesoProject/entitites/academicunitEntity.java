package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "Academicunit")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class academicunitEntity {
    @OneToMany (mappedBy = "Academicunit", cascade = CascadeType.ALL)
    private List<leadershipEntity> leadershipEntities;

    @OneToMany (mappedBy = "Academicunit", cascade = CascadeType.ALL)
    private List<analyzerEntity> analyzerEntities;

    @OneToMany (mappedBy = "Academicunit", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_academicunit;
}
