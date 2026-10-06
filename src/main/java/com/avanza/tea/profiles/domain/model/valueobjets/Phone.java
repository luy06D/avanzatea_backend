package com.avanza.tea.profiles.domain.model.valueobjets;

public record Phone(String value) {

    public Phone{
        if(!value.matches("^9[0-9]{8}$")){
            throw new IllegalArgumentException("El número de celular debe con 9 y tener 9 digitos");
        }

    }
}
