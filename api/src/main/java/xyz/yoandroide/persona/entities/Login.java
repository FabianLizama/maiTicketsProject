package xyz.yoandroide.persona.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Login")
public class Login {
    @Id
    private String email;
    private String password;

}
