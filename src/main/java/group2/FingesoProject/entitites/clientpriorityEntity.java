package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Clientpriority")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class clientpriorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_clientpriority;

    private String clientpriority_name;

    @OneToMany(mappedBy = "clientPriority")
    private List<externalclientEntity> externalClients;

    @OneToMany(mappedBy = "clientPriority")
    private List<internalclientEntity> internalClients;
}
