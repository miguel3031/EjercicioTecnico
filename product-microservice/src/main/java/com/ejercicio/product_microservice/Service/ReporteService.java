package com.ejercicio.product_microservice.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.product_microservice.Modelo.Movimiento;
import com.ejercicio.product_microservice.Repository.MovimientoRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReporteService {
      @Autowired
    private final MovimientoRepository movimientoRepo;
   
    
       public List<Movimiento> obtenerMovimientosFiltrados(Date fechaInicio, Date fechaFin, Integer identificacion) {
        return movimientoRepo.buscarPorRangoDeFechasYCliente(fechaInicio, fechaFin, identificacion);
    }
    
      

}
