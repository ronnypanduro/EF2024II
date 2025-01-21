package com.examen.app_seguridad.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="seguridad")
public class UsuarioModel {
    @Id
    @Column(name="id_seguridad")
    public Integer idSeguridad;

    @Column(name= "nombre")
    public String nombre;

    @Column(name= "clave")
    public String clave;

}
