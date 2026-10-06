package com.avanza.tea.profiles.infraestructure.persistence.jpa.repositories;

import com.avanza.tea.profiles.infraestructure.persistence.jpa.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByIdentity(String identity);
    Optional<PersonEntity> findByEmail(String email);

}
