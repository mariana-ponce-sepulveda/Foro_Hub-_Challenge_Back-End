package com.andromeda.forohub.infra.security;

import jakarta.validation.constraints.NotBlank;

public record UserAuthentication(
        @NotBlank(message = "El email no debe quedar vacio") String email,
        @NotBlank(message = "La contraseña no debe quedar vacio") String password) {
}
