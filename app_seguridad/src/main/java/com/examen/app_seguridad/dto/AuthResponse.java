package com.examen.app_seguridad.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String token;
    private final String userName;
    private final String accessTokenExpiration;
}
