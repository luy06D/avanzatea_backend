package com.avanza.tea.iam.domain.repositories;

import com.avanza.tea.iam.domain.model.aggregates.User;
import com.avanza.tea.iam.domain.model.valueobjets.UserName;

import java.util.List;
import java.util.Optional;
// Repository : define las operaciones de guardado y busqueda.
public interface UserRepository {
    User saveUser(User user); // saveUser & update
    Optional<User> findById(Long id);
    List<User> findAll();
    Optional<User> findByUserName(UserName userName);
    boolean existsByUsername(UserName userName);
}
