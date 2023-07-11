package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticketdocument")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ticketdocumentEntity {

    @ManyToOne
    @JoinColumn (name = "ticket")
    private ticketEntity ticketEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_ticketdocument;
    String document_description;
}
