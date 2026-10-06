package com.avanza.tea.iam.application.dto;

public record UpdateUserCommand(
        Long iduser,
        Long idperson,
        String username,
        String role
) {
}
