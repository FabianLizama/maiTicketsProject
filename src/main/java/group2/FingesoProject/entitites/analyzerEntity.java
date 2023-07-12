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
public class analyzerEntity extends user_infoEntity {

    @OneToMany(mappedBy = "analyzer", cascade = CascadeType.ALL)
    public List<ticketEntity> tickets;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long id_analyzer;

    @OneToMany(mappedBy = "analyzer")
    private leadershipEntity leadershipEntity;

    public leadershipEntity getLeadershipEntity() {
        return leadershipEntity;
    }

    public void setLeadershipEntity(leadershipEntity leadershipEntity) {
        this.leadershipEntity = leadershipEntity;
    }
}
