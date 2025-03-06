package com.ejercicio.product_microservice.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ejercicio.product_microservice.Modelo.Movimiento;


@Repository //nos premite crear los cruds 
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>  {

     @Query("""
        SELECT m
        FROM Movimiento m 
        WHERE m.fechaMovimiento BETWEEN :fechaInicio AND :fechaFin 
          AND :identificacion = m.identificacionCliente
    """)
    List<Movimiento> buscarPorRangoDeFechasYCliente(
        @Param("fechaInicio") Date fechaInicio,
        @Param("fechaFin") Date fechaFin,
        @Param("identificacion") Integer identificacion
    );

    
} 
