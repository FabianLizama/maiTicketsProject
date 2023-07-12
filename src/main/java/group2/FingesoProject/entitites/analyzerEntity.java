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
public class analyzerEntity extends userInfoEntity {

    @OneToMany(mappedBy = "analyzer", cascade = CascadeType.ALL)
    public List<ticketEntity> tickets;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long id_analyzer;
    @OneToMany(mappedBy = "analyzer")
    private Collection<group2.FingesoProject.entitites.leadershipEntity> leadershipEntity;

    public Collection<group2.FingesoProject.entitites.leadershipEntity> getLeadershipEntity() {
        return leadershipEntity;
    }

    public void setLeadershipEntity(Collection<group2.FingesoProject.entitites.leadershipEntity> leadershipEntity) {
        this.leadershipEntity = leadershipEntity;
    }
}
