package com.Api.Crud_1.controller;


import com.Api.Crud_1.model.Coche;
import com.Api.Crud_1.model.Motocicleta;
import com.Api.Crud_1.model.Vehiculo;
import com.Api.Crud_1.service.VehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {


    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    //Get /vehiculos
    @GetMapping
    public ResponseEntity<List<Vehiculo>> getAllVehiculos() {
        return ResponseEntity.ok(vehiculoService.findAll());
    }
    //Get /vehiculos/coches
    @GetMapping("/coches")
    public ResponseEntity<List<Coche>> getAllCoches() {
        //usa ResponseEntity para devolver una respuesta HTTP con el estado 200 OK y la lista de coches en el cuerpo de la respuesta.
        return ResponseEntity.ok(vehiculoService.findAll().stream()
                .filter(vehiculo -> vehiculo instanceof Coche)
                .map(vehiculo -> (Coche) vehiculo)
                .toList());
    }

    //Get /vehiculos/motos
    @GetMapping("/motos")
    public ResponseEntity<List<Motocicleta>> getAllMotos() {
        return ResponseEntity.ok(vehiculoService.findAll().stream()
                .filter(vehiculo -> vehiculo instanceof Motocicleta)
                .map(vehiculo -> (Motocicleta) vehiculo)
                .toList());
    }

    //Get /vehiculos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.findById(id));
    }

    // POST /vehiculos
    @PostMapping("/coches")
    public ResponseEntity<Vehiculo> createCoche(@RequestBody Coche coche) {
        return ResponseEntity.ok(vehiculoService.save(coche));
    }

    // POST /vehiculos
    @PostMapping("/motos")
    public ResponseEntity<Vehiculo> createMotos(@RequestBody Motocicleta moto) {
        return ResponseEntity.ok(vehiculoService.save(moto));
    }
    //UPDATE /vehiculos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> update(@PathVariable Long id , @RequestBody Vehiculo vehiculo) {
        Vehiculo existingVehiculo = vehiculoService.findById(id);
        // Aquí puedes actualizar los campos del vehículo existente con los valores del vehículo recibido
        // Por ejemplo:
        existingVehiculo.setMarca(vehiculo.getMarca());
        existingVehiculo.setModelo(vehiculo.getModelo());
        existingVehiculo.setAnho(vehiculo.getAnho());
        // Guarda el vehículo actualizado
        Vehiculo updatedVehiculo = vehiculoService.save(existingVehiculo);
        return ResponseEntity.ok(updatedVehiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehiculoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
