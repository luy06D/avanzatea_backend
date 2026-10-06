package com.avanza.tea.iam.infraestructure.persitence.jpa.entities;
import com.avanza.tea.profiles.infraestructure.persistence.jpa.entities.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotacion
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Long iduser;
    // Relacion con Person
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idperson", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_per"))
    private PersonEntity person;
    @Column(name = "username", unique = true, nullable = false, length = 30)
    private String username;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "role", nullable = false, length = 20)
    private String role;
    @Column(name = "status", nullable = false, length = 20)
    private String status;

}


