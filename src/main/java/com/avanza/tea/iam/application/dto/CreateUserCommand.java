package com.avanza.tea.iam.application.dto;

// Transporta datos que envia el cliente
public record CreateUserCommand(
        Long idperson,
        String username,
        String password,
        String role
) {
}
