package com.examen.app_seguridad.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;  
}
