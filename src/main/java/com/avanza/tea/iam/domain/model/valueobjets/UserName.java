package com.avanza.tea.iam.domain.model.valueobjets;

public record UserName(String value) {

    public UserName{
        if(value == null || value.trim().isEmpty()){
            throw new IllegalArgumentException("The username cannot be empty");
        }
    }
}
