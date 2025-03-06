package com.ejercicio.product_microservice.Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    private Integer identificacionUsuario;
    @Basic
    private String nombreUsuario;
    private String direccionUsuario;
    private String telefonoUsuario;
    private String contrasenaUsuario;
    private Boolean estadoUsuario;
}
