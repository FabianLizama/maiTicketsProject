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
public class clientPriorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_clientpriority;

    private String clientpriority_name;

    @OneToMany(mappedBy = "clientPriority")
    private List<externalClientEntity> externalClients;

    @OneToMany(mappedBy = "clientPriority")
    private List<internalClientEntity> internalClients;
}
