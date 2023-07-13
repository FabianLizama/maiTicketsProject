package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Analyzer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class analyzerEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long id_analyzer;

    @ManyToOne
    @JoinColumn(name = "id_userInfo")
    private userInfoEntity userInfoEntity;

    @ManyToOne
    @JoinColumn(name = "id_academicUnit")
    private academicUnitEntity academicUnitEntity;

    @ManyToOne
    @JoinColumn(name = "id_leadership")
    private leadershipEntity leadershipEntity;

    }
