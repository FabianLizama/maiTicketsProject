package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ticketdocument")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ticketdocumentEntity {

    @ManyToOne
    @JoinColumn (name = "Ticket")
    private ticketEntity ticketEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_document;
    String document_description;
}
