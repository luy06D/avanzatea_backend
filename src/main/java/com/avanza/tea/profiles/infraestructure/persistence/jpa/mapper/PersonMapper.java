package com.avanza.tea.profiles.infraestructure.persistence.jpa.mapper;

import com.avanza.tea.profiles.domain.model.aggregates.Person;
import com.avanza.tea.profiles.domain.model.enums.DocumentType;
import com.avanza.tea.profiles.domain.model.valueobjets.Email;
import com.avanza.tea.profiles.domain.model.valueobjets.Identity;
import com.avanza.tea.profiles.domain.model.valueobjets.Phone;
import com.avanza.tea.profiles.infraestructure.persistence.jpa.entities.PersonEntity;

public class PersonMapper {

    public PersonEntity toEntity(Person person){
        PersonEntity personEntity = new PersonEntity();

        personEntity.setIdperson(person.getIdPerson());
        personEntity.setName(person.getName());
        personEntity.setLastname(person.getLastname());
        personEntity.setIdentity(person.getIdentity().value());
        personEntity.setEmail(person.getEmail().value());
        personEntity.setPhone(person.getPhone().value());

        return personEntity;
    }

    public Person toDomain(PersonEntity personEntity){
        Identity identity = new Identity(DocumentType.DNI, personEntity.getIdentity());
        return new Person(
                personEntity.getIdperson(),
                personEntity.getName(),
                personEntity.getLastname(),
                identity,
                new Email(personEntity.getEmail()),
                new Phone(personEntity.getPhone())

        );
    }

}
