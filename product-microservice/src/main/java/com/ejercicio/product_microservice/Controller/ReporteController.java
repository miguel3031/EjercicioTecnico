package com.ejercicio.product_microservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.product_microservice.Modelo.Movimiento;
import com.ejercicio.product_microservice.Service.ReporteService;


import lombok.RequiredArgsConstructor;


import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/reporte")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService movimientosService;

     @GetMapping("/filtrar")
    public List<Movimiento> filtrarPedidos(
        @RequestParam Date fechaInicio,
        @RequestParam Date fechaFin,
        @RequestParam Integer cliente
    ) {
        return movimientosService.obtenerMovimientosFiltrados(fechaInicio, fechaFin, cliente);
    }
}
