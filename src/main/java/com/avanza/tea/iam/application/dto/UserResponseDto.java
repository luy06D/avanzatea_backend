package com.avanza.tea.iam.application.dto;

import com.avanza.tea.iam.domain.model.aggregates.User;

// Define lo que devolvemos al cliente
public record UserResponseDto(
    Long idUser,
    Long idPerson,
    String username,
    String role,
    String status
) {
// Extrae la informacion publica y la convierte en tipos simples
    public static UserResponseDto fromDomain(User user){
        return new UserResponseDto(
                user.getIdUser(),
                user.getIdPerson(),
                user.getUsername().value(),
                user.getRol().name(),
                user.getStatus().name()
        );
    }


}
