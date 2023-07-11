package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clientpriority")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class clientpriorityEntity {

    @OneToMany (mappedBy = "clientpriority", cascade = CascadeType.ALL)
    private List<internalclientEntity> internalclientEntities;

    @OneToMany (mappedBy = "clientpriority", cascade = CascadeType.ALL)
    private List<externalclientEntity> externalclientEntities;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_clientpriority;
    String clientpriority_name;
}
