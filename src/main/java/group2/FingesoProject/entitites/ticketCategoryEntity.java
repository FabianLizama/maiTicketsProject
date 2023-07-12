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
public class ticketCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_ticketcategory;

    private String category_name;

    @OneToMany(mappedBy = "ticketCategory")
    private List<ticketEntity> tickets;
}
