package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "externalClient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class externalClientEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_externalClient;

    private String priority_name;

    @ManyToOne
    @JoinColumn(name = "id_userInfo")
    private userInfoEntity userInfoEntity;

    @ManyToOne
    @JoinColumn(name = "id_clientPriority")
    private clientPriorityEntity clientPriority;

}
