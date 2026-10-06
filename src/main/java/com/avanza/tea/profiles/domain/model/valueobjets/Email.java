package com.avanza.tea.profiles.domain.model.valueobjets;

public record Email(String value) {
    public Email{
        if(value == null || value.trim().isEmpty()){
            throw new IllegalArgumentException("Email cannot be null");
        }

        String pattern =  "^[A-Za-z0-9._%+-]+@gmail\\\\.com$";
        if(!value.matches(pattern)){
            throw new IllegalArgumentException("El email debe tener el formato correcto");
        }
    }

}
