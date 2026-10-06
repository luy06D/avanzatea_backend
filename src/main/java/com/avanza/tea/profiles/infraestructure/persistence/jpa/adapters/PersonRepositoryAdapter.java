package com.avanza.tea.profiles.infraestructure.persistence.jpa.adapters;

import com.avanza.tea.profiles.domain.model.aggregates.Person;
import com.avanza.tea.profiles.domain.repositories.PersonRepository;
import com.avanza.tea.profiles.infraestructure.persistence.jpa.entities.PersonEntity;
import com.avanza.tea.profiles.infraestructure.persistence.jpa.mapper.PersonMapper;
import com.avanza.tea.profiles.infraestructure.persistence.jpa.repositories.PersonJpaRepository;

import java.util.List;
import java.util.Optional;


public class PersonRepositoryAdapter implements PersonRepository {

    private final PersonJpaRepository jpaRepository;
    private final PersonMapper personMapper;

    public PersonRepositoryAdapter(PersonJpaRepository jpaRepository, PersonMapper personMapper) {
        this.jpaRepository = jpaRepository;
        this.personMapper = personMapper;
    }

    @Override
    public Person savePerson(Person person) {

        PersonEntity personEntity = personMapper.toEntity(person);
        PersonEntity saved = jpaRepository.save(personEntity);
        return personMapper.toDomain(saved);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return jpaRepository.findById(id).map(personMapper::toDomain);
    }

    @Override
    public List<Person> findAll() {
        return jpaRepository.findAll().stream()
                .map(personMapper::toDomain).toList();
    }

    @Override
    public Optional<Person> findByIdentity(String identity) {
        return jpaRepository.findByIdentity(identity)
                .map(personMapper::toDomain);
    }

    @Override
    public Optional<Person> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(personMapper::toDomain);
    }


}
