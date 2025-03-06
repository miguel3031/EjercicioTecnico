package com.ejercicio.product_microservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.product_microservice.Modelo.Cliente;
import com.ejercicio.product_microservice.Modelo.Cuenta;
import com.ejercicio.product_microservice.Repository.ClientesRepository;
import com.ejercicio.product_microservice.Repository.CuentaRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaService {
      @Autowired
    private final CuentaRepository cuentaRepo;
    private final ClientesRepository clienteRepo;
    private Cliente cliente;
    public List<Cuenta> listarCuenta() {
        return cuentaRepo.findAll();
    }

    @SuppressWarnings("deprecation")
    public String createCuenta(Cuenta cuenta)
    {
        if (cuentaRepo.existsById(cuenta.getNumeroCuenta())) {
            return "El número de cuenta ya se encuentra registrado: " + cuenta.getNumeroCuenta();
        }
        cliente = clienteRepo.getById(cuenta.getIdentificacionCliente());
        cuenta.setClienteCuenta(cliente.getNombreUsuario());
            cuentaRepo.save(cuenta);
        return "Registro creado";
      
       
    }

    @SuppressWarnings("deprecation")
    public String actualizarCuenta(Integer id, Cuenta cuentaActualizar)
    {
        
        return cuentaRepo.findById(id)
                .map(cuenta -> {
                    cuenta.setEstadoCuenta(cuentaActualizar.getEstadoCuenta());
                    cuenta.setClienteCuenta(cuentaActualizar.getClienteCuenta());
                    cuenta.setSaldoInicialCuenta(cuentaActualizar.getSaldoInicialCuenta());
                    cuenta.setTipoCuenta(cuentaActualizar.getTipoCuenta());
                    cuenta.setIdentificacionCliente(cuentaActualizar.getIdentificacionCliente());
                    cliente = clienteRepo.getById(cuentaActualizar.getIdentificacionCliente());
                    cuenta.setClienteCuenta(cliente.getNombreUsuario());
                    cuentaRepo.save(cuenta);
                    return "Registro actualizado";
                }).orElseThrow(() -> new RuntimeException("Cuenta no encontrado"));
    }
     public String eliminarCuenta(Integer id) {
        if (!cuentaRepo.existsById(id)) {
            throw new EntityNotFoundException("Cuenta no encontrado con ID: " + id);
        }
        cuentaRepo.deleteById(id);
        return "Cuenta eliminada exitosamente";
    }

}
