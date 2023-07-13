package group2.FingesoProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ClientPriority")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class clientPriorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_clientPriority;

    private String clientPriority_name;
}
