package com.Api.Crud_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.charset.MalformedInputException;

@Getter
@Setter
@NoArgsConstructor
@Entity
public abstract class Vehiculo {

    @Id
    // Identity es una estrategia de generación de claves primarias donde la base de datos genera automáticamente
    // //un valor único para el campo ID cada vez que se inserta un nuevo registro.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotación para la generación automática del ID
    private Long id; // Identificador único del vehículo

    @NotBlank(message = "La marca no puede estar vacía")
    private String marca;
    @NotBlank(message = "El modelo no puede estar vacío")
    private String modelo;
    @NotBlank(message = "El año no puede estar vacío")
    @Min(value = 1886, message = "El año debe ser mayor o igual a 1886")
    private int anho;

    public Vehiculo(String marca, String modelo, int anho) {
        this.marca = marca;
        this.modelo = modelo;
        this.anho = anho;
    }
}
