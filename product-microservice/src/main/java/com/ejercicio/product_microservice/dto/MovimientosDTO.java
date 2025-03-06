package com.ejercicio.product_microservice.dto;

import java.math.BigDecimal;
import java.util.Date;

public record MovimientosDTO(Date fechaMovimiento, String clienteMovimiento, Integer numeroCuenta, String tipoCuenta, BigDecimal saldoInicialCuenta, String estadoMovimiento, BigDecimal montoMovimiento, BigDecimal saldoDisponibleCuenta) {

}
