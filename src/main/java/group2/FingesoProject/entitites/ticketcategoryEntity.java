package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Ticketcategory")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ticketcategoryEntity {

    @OneToMany (mappedBy = "Ticketcategory", cascade = CascadeType.ALL)
    private List<ticketEntity> ticketEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_ticketcategory;
    String category_name;
}
