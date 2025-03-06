package com.ejercicio.product_microservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.product_microservice.Modelo.Movimiento;
import com.ejercicio.product_microservice.Service.MovimientoService;


import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovimientoController {

    private final MovimientoService movimientosService;

     @GetMapping
    public ResponseEntity<List<Movimiento>> listarProductos() {
        List<Movimiento> MovimientoLista = movimientosService.listarMovimiento();
        return ResponseEntity.ok(MovimientoLista);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> crearPersona(@RequestBody Movimiento movimiento){
        String mensaje = movimientosService.createMovimiento(movimiento);
        return ResponseEntity.ok(Map.of("mensaje", mensaje));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> actualizarMovimiento(@PathVariable Integer id, @RequestBody  Movimiento movimiento) {
        String mensaje = movimientosService.actualizarMovimiento(id,movimiento);
        return ResponseEntity.ok(Map.of("mensaje", mensaje));
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminarMovimiento(@PathVariable Integer id) {
        
        String mensaje = movimientosService.eliminarMovimiento(id);
        return ResponseEntity.ok(Map.of("mensaje", mensaje));
    }
}
