package com.ejercicio.product_microservice.Modelo;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movimiento {
    @Id
    @GeneratedValue
    private Integer idMovimiento;
    @Basic
    private Integer numeroCuenta;
    private Integer identificacionCliente;
    private String tipoCuenta;
    private BigDecimal saldoInicialCuenta;
    private Boolean estadoMovimiento;
    private String descripcionMovimiento;
    private BigDecimal saldoDisponibleCuenta;
    private BigDecimal montoMovimiento;
    private String clienteMovimiento;
    private Date fechaMovimiento;
}
