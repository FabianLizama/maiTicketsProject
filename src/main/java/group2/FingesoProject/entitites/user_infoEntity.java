package group2.FingesoProject.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "User_info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class user_infoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id_user_info;
    String name;
    String lastname_p;
    String lastname_m;
    String rut;
    String mail;
    String password;
    Date birthdate;

    // Getter and Setter methods (omitted for brevity)
}
