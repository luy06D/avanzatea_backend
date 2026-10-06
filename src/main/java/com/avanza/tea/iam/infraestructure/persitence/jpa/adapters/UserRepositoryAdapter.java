package com.avanza.tea.iam.infraestructure.persitence.jpa.adapters;


import com.avanza.tea.iam.domain.model.aggregates.User;
import com.avanza.tea.iam.domain.model.valueobjets.UserName;
import com.avanza.tea.iam.domain.repositories.UserRepository;
import com.avanza.tea.iam.infraestructure.persitence.jpa.mapper.UserMapper;
import com.avanza.tea.iam.infraestructure.persitence.jpa.entities.UserEntity;
import com.avanza.tea.iam.infraestructure.persitence.jpa.repositories.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository jpaRepository;
    private final UserMapper userMapper;

    public UserRepositoryAdapter(UserJpaRepository jpaRepository, UserMapper userMapper) {
        this.jpaRepository = jpaRepository;
        this.userMapper = userMapper;
    }
    // Save maneja creción y actualización
    @Override
    public User saveUser(User user) {

        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity saved = jpaRepository.save(userEntity);

        return userMapper.toDomian(saved);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id).map(userMapper::toDomian);
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll().stream()
                .map(userMapper::toDomian).toList();
    }

    @Override
    public Optional<User> findByUserName(UserName userName) {
        return jpaRepository.findByUsername(userName.value()).map(userMapper::toDomian);

    }

    @Override
    public boolean existsByUsername(UserName userName) {
        return jpaRepository.existsByUsername(userName.value());
    }
}
