package com.ejercicio.product_microservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.product_microservice.Modelo.Cliente;

import com.ejercicio.product_microservice.Repository.ClientesRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientesService {
      @Autowired
    private final ClientesRepository clienteRepo;
    
    

    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    public String createCliente(Cliente cliente)
    {
        try{
            if (clienteRepo.existsById(cliente.getIdentificacionUsuario())) {
                return "El número de cédula ya se encuentra registrado: " + cliente.getIdentificacionUsuario();
            }
            clienteRepo.save(cliente);
            return "Registro creado";
        }catch(EntityNotFoundException es){
            return "Error al crear el registro: " + es.getLocalizedMessage();
        }
       
    }

    public String actualizarCliente(Integer id, Cliente clienteActualizar)
    {
        
        return clienteRepo.findById(id)
                .map(cliente -> {
                    cliente.setDireccionUsuario(clienteActualizar.getDireccionUsuario());
                    cliente.setNombreUsuario(clienteActualizar.getNombreUsuario());
                    cliente.setContrasenaUsuario(clienteActualizar.getContrasenaUsuario());
                    cliente.setTelefonoUsuario(clienteActualizar.getTelefonoUsuario());
                    cliente.setEstadoUsuario(clienteActualizar.getEstadoUsuario());
                    clienteRepo.save(cliente);
                    return "Registro actualizado";
                }).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
     public String eliminarCliente(Integer id) {
        if (!clienteRepo.existsById(id)) {
            throw new EntityNotFoundException("Cliente no encontrado con ID: " + id);
        }
        clienteRepo.deleteById(id);
        return "Cliente eliminado exitosamente";
    }

}
