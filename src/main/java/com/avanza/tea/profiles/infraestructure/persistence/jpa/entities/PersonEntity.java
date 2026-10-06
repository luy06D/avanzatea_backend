package com.avanza.tea.profiles.infraestructure.persistence.jpa.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson")
    private Long idperson;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "identity", nullable = false, unique = true)
    private String identity;
    @Column(name = "email", nullable = true, unique = true )
    private String email;
    @Column(name = "phone", nullable = true, unique = true)
    private String phone;
}
