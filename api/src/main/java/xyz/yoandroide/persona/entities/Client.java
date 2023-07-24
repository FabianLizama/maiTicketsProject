package xyz.yoandroide.persona.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClient;
    private String name;
    private String lastNameP;
    private String lastNameM;
    private String rut;
    private String email;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    private List<Ticket> tickets;

}
