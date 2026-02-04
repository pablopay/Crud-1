package com.Api.Crud_1.service;

import com.Api.Crud_1.model.Vehiculo;
import com.Api.Crud_1.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    // Inyección del repositorio de Vehículo
    private final VehiculoRepository vehiculoRepository;

    // Constructor para la inyección de dependencias
    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    // Aquí irían los métodos para manejar la lógica de negocio relacionada con Vehículo

    // Método para guardar un vehículo
   public Vehiculo save(Vehiculo vehiculo) {
       // Lógica para guardar un vehículo
       return vehiculoRepository.save(vehiculo);
   }

   // Método para obtener todos los vehículos
   public List<Vehiculo> findAll() {
       // Lógica para obtener todos los vehículos
       return vehiculoRepository.findAll();
   }

   // Leer un vehículo por su ID
    public Vehiculo findById(Long id) {
        return vehiculoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Vehículo no encontrado con ID: " + id
        ));
    }

    // Método para eliminar un vehículo por su ID
    public void deleteById(Long id) {
        if (!vehiculoRepository.existsById(id)) {
            throw new RuntimeException("Vehículo no encontrado con ID: " + id);
        }
        vehiculoRepository.deleteById(id);

    }


}
