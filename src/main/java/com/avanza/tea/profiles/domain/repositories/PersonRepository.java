package com.avanza.tea.profiles.domain.repositories;

import com.avanza.tea.profiles.domain.model.aggregates.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person savePerson(Person person);
    Optional<Person> findById(Long id);
    List<Person> findAll();
    Optional<Person> findByIdentity(String identity);
    Optional<Person> findByEmail(String email);

}


