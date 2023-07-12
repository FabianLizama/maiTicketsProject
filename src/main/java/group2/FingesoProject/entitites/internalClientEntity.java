package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Internalclient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class internalClientEntity extends userInfoEntity {

    @ManyToOne
    @JoinColumn(name = "id_clientpriority")
    private clientPriorityEntity clientPriority;

    @OneToMany(mappedBy = "internalClient", cascade = CascadeType.ALL)
    private List<ticketEntity> tickets;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_internalclient;

    private String priority_name;
}
