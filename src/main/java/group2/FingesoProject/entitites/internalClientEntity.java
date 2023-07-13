package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "internalClient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class internalClientEntity{

    @ManyToOne
    @JoinColumn(name = "id_internalClient")
    private userInfoEntity userInfoEntity;

    @ManyToOne
    @JoinColumn(name = "id_clientPriority")
    private clientPriorityEntity clientPriority;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_internalClient;

    private String priority_name;
}
