package com.ejercicio.product_microservice.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.product_microservice.Modelo.Cuenta;
import com.ejercicio.product_microservice.Modelo.Movimiento;

import com.ejercicio.product_microservice.Repository.CuentaRepository;
import com.ejercicio.product_microservice.Repository.MovimientoRepository;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientoService {
      @Autowired
    private final MovimientoRepository movimientoRepo;
    private final CuentaRepository cuentaRepo;
    private Cuenta cuenta;
    private Movimiento movimientoEliminar;
    
        public List<Movimiento> listarMovimiento() {
            return movimientoRepo.findAll();
        }
    
        @SuppressWarnings("deprecation")
        public String createMovimiento(Movimiento movimiento)
        {
            if (!cuentaRepo.existsById(movimiento.getNumeroCuenta())) {
                return "El número de cuenta no existe: " + movimiento.getNumeroCuenta();
            }
            cuenta = cuentaRepo.getById(movimiento.getNumeroCuenta());
            movimiento.setFechaMovimiento(new Date());
            movimiento.setSaldoInicialCuenta(cuenta.getSaldoInicialCuenta());
            movimiento.setSaldoDisponibleCuenta(cuenta.getSaldoInicialCuenta().add(movimiento.getMontoMovimiento()));
            movimiento.setClienteMovimiento(cuenta.getClienteCuenta());
            movimiento.setIdentificacionCliente(cuenta.getIdentificacionCliente());
           if(movimiento.getSaldoDisponibleCuenta().doubleValue() < 0)
           {
            return "Saldo insuficiente para realizar ese movimiento";
           }
            movimientoRepo.save(movimiento);
        cuenta.setSaldoInicialCuenta(movimiento.getSaldoDisponibleCuenta());
        cuentaRepo.save(cuenta);
        return "Registro creado";
      
       
    }

    @SuppressWarnings("deprecation")
    public String actualizarMovimiento(Integer id, Movimiento movimientoActualizar)
    {
        
        return movimientoRepo.findById(id)
                .map(movimiento -> {                  
                    cuenta = cuentaRepo.getById(movimientoActualizar.getNumeroCuenta());
                    movimientoActualizar.setFechaMovimiento(new Date());
                    movimientoActualizar.setSaldoInicialCuenta(cuenta.getSaldoInicialCuenta());
                    movimientoActualizar.setSaldoDisponibleCuenta(cuenta.getSaldoInicialCuenta().add(movimiento.getMontoMovimiento()));
                    movimientoActualizar.setClienteMovimiento(cuenta.getClienteCuenta());
                    movimientoActualizar.setIdentificacionCliente(cuenta.getIdentificacionCliente());
                    if(movimientoActualizar.getSaldoDisponibleCuenta().doubleValue() < 0)
                    {
                     return "Saldo insuficiente para realizar ese movimiento";
                    }
                    movimientoRepo.save(movimientoActualizar);
                    cuenta.setSaldoInicialCuenta(movimientoActualizar.getSaldoDisponibleCuenta());
                    cuentaRepo.save(cuenta);  
                    movimientoRepo.save(movimientoActualizar);
                    return "Registro actualizado";
                }).orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
    }
     @SuppressWarnings("deprecation")
    public String eliminarMovimiento(Integer id) {
        if (!movimientoRepo.existsById(id)) {
            throw new EntityNotFoundException("Movimiento no encontrado con ID: " + id);
        }
       
        movimientoEliminar = movimientoRepo.getById(id);
        cuenta = cuentaRepo.getById(movimientoEliminar.getNumeroCuenta());
        cuenta.setSaldoInicialCuenta(cuenta.getSaldoInicialCuenta().subtract(movimientoEliminar.getSaldoDisponibleCuenta()));
        cuentaRepo.save(cuenta);  
        movimientoRepo.deleteById(id);
        return "Movimiento eliminada exitosamente";
    }

}
