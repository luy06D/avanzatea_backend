package com.avanza.tea.iam.domain.model.valueobjets;

public record Password(String password) {

    public Password{
        if(password == null || password.trim().isEmpty()){
            throw new IllegalArgumentException("The password cannot be empty");
        }

        if(password.length() < 8){
            throw new IllegalArgumentException("The password cannot be less than 8 characters");
        }
    }
}
