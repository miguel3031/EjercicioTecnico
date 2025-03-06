package com.ejercicio.product_microservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.product_microservice.Modelo.Cuenta;
import com.ejercicio.product_microservice.Service.CuentaService;


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
@RequestMapping("/api/cuentas")
@RequiredArgsConstructor
public class CuentaController {

    private final CuentaService cuentasService;

     @GetMapping
    public ResponseEntity<List<Cuenta>> listarProductos() {
        List<Cuenta> CuentaLista = cuentasService.listarCuenta();
        return ResponseEntity.ok(CuentaLista);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> crearPersona(@RequestBody Cuenta Cuenta){
        String mensaje = cuentasService.createCuenta(Cuenta);
        return ResponseEntity.ok(Map.of("mensaje", mensaje));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> actualizarCuenta(@PathVariable Integer id, @RequestBody  Cuenta Cuenta) {
        String mensaje = cuentasService.actualizarCuenta(id,Cuenta);
        return ResponseEntity.ok(Map.of("mensaje", mensaje));
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminarCuenta(@PathVariable Integer id) {
        
        String mensaje = cuentasService.eliminarCuenta(id);
        return ResponseEntity.ok(Map.of("mensaje", mensaje));
    }
}
