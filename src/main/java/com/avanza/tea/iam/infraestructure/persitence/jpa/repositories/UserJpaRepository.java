package com.avanza.tea.iam.infraestructure.persitence.jpa.repositories;

import com.avanza.tea.iam.infraestructure.persitence.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    // se define operacion que no estan en UserRepository de domain

    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String name);

}
