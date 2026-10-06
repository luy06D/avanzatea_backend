package com.avanza.tea.profiles.domain.model.valueobjets;

import com.avanza.tea.profiles.domain.model.enums.DocumentType;

public record Identity(DocumentType type, String value) {

    public Identity{
        if(type == null){
            throw new IllegalArgumentException("The type is mandatory ");
        }
        if(value == null || value.trim().isEmpty()){
            throw new IllegalArgumentException("Identity cannot be empty ");
        }

        String valueType = value.trim();

        switch (type){
            case DNI -> {
                if(!valueType.matches("^[0-9]{8}$")){
                    throw new IllegalArgumentException("El DNI debe contener exactamente 8 dígitos");
                }
            }

            case PASSPORT -> {
                if(!valueType.matches("^[A-Za-z0-9]{6,12}$")){
                    throw new IllegalArgumentException("El pasaporte debe tener entre 6 y 12 caracteres alfanumericos");
                }
            }

            case CE -> {
                if(!valueType.matches("^[A-Za-z0-9]{9,12}$")){
                    throw new IllegalArgumentException("El carné de extranjeria debe tener entre 9 y 12 caracteres alfanumericos");
                }
            }
        }
        //limpio en mayusculas..
        value = valueType.toUpperCase();



    }
}
