package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Ticketrating")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ticketratingEntity {

    @OneToMany (mappedBy = "Ticketrating", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_rating;
    Integer rating;
    String rating_description;
}
