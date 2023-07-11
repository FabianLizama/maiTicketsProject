package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "externalclient")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class externalclientEntity extends user_infoEntity {

    @ManyToOne
    @JoinColumn (name = "clientpriority")
    private clientpriorityEntity clientpriorityEntity;

    @OneToMany (mappedBy = "externalclient", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_externalclient;
    String priority_name;
}
