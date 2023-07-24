package xyz.yoandroide.persona.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAdmin;
    private String name;
    private String password;
    private String email;

}
