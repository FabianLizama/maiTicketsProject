package group2.FingesoProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ExternalClient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class externalClientEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_externalClient;

    private String Priority_name;

    @ManyToOne
    @JoinColumn(name = "id_userInfo")
    private userInfoEntity userInfoEntity;

    @ManyToOne
    @JoinColumn(name = "id_clientPriority")
    private clientPriorityEntity clientPriority;

}
