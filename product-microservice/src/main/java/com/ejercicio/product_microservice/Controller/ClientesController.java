package com.ejercicio.product_microservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.product_microservice.Modelo.Cliente;
import com.ejercicio.product_microservice.Service.ClientesService;

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
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClientesController {

    private final ClientesService clientesService;

     @GetMapping
    public ResponseEntity<List<Cliente>> listarProductos() {
        List<Cliente> clienteLista = clientesService.listarClientes();
        return ResponseEntity.ok(clienteLista);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> crearPersona(@RequestBody Cliente cliente){
        String mensaje = clientesService.createCliente(cliente);
        return ResponseEntity.ok(Map.of("mensaje", mensaje));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> actualizarCliente(@PathVariable Integer id, @RequestBody  Cliente cliente) {
        String mensaje = clientesService.actualizarCliente(id,cliente);
        return ResponseEntity.ok(Map.of("mensaje", mensaje));
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminarCliente(@PathVariable Integer id) {
        
        String mensaje = clientesService.eliminarCliente(id);
        return ResponseEntity.ok(Map.of("mensaje", mensaje));
    }
}
