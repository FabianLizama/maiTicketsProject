package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Externalclient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class externalClientEntity extends userInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_externalclient;

    private String priority_name;

    @ManyToOne
    @JoinColumn(name = "id_clientpriority")
    private clientPriorityEntity clientPriority;

    @OneToMany(mappedBy = "externalClient", cascade = CascadeType.ALL)
    private List<ticketEntity> tickets;
}
