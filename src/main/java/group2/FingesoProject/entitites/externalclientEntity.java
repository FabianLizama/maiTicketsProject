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

public class externalclientEntity extends userEntity {

    @ManyToOne
    @JoinColumn (name = "Clientpriority")
    private clientpriorityEntity clientpriorityEntity;

    @OneToMany (mappedBy = "Externalclient", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_externalclient;
    String priority_name;
}
