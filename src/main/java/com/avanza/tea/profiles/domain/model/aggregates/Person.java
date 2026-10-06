package com.avanza.tea.profiles.domain.model.aggregates;

import com.avanza.tea.profiles.domain.model.valueobjets.Email;
import com.avanza.tea.profiles.domain.model.valueobjets.Identity;
import com.avanza.tea.profiles.domain.model.valueobjets.Phone;

public class Person {
    private Long idPerson;
    private String name;
    private String lastname;
    private Identity identity;
    private Email email;
    private Phone phone;

    public Person(Long idPerson, String name, String lastname, Identity identity, Email email, Phone phone) {
        this.idPerson = idPerson;
        this.name = name;
        this.lastname = lastname;
        this.identity = identity;
        this.email = email;
        this.phone = phone;
    }

    // Create Person
    public static Person createNew(String name , String lastname, Identity identity, Email email, Phone phone ){
        return new Person(null, name, lastname, identity, email, phone);
    }

    //Update Person
    public void updatePerson(String name , String lastname, Identity identity, Email email, Phone phone){
        if(name == null || lastname == null || identity == null){
            throw new IllegalArgumentException("Complete los campos obligatorios");
        }

        this.name = name;
        this.lastname = lastname;
        this.identity = identity;
        this.email = email;
        this.phone = phone;
    }


    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
