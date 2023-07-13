package group2.FingesoProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Leadership")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class leadershipEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_leadership;

    @ManyToOne
    @JoinColumn(name = "id_userInfo")
    private userInfoEntity userInfoEntity;

    @ManyToOne
    @JoinColumn(name = "id_academicUnit")
    private academicUnitEntity academicUnitEntity;


    // Getter and Setter methods (omitted for brevity)
}
