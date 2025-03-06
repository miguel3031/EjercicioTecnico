package com.ejercicio.product_microservice.Modelo;

import java.math.BigDecimal;

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
public class Cuenta {
    @Id
    private Integer numeroCuenta;
    @Basic
    private String tipoCuenta;
    private BigDecimal saldoInicialCuenta;
    private String clienteCuenta;
    private Integer identificacionCliente;
    private Boolean estadoCuenta;
}
