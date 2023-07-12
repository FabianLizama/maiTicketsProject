package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "internalclient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class internalclientEntity extends user_infoEntity {

    @ManyToOne
    @JoinColumn(name = "id_clientpriority")
    private clientpriorityEntity clientPriority;

    @OneToMany(mappedBy = "internalclient", cascade = CascadeType.ALL)
    private List<ticketEntity> tickets;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_internalclient;

    private String priority_name;
}
