package com.Api.Crud_1.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("COCHE") // Valor para distinguir esta subclase en la tabla de Vehiculo
public class Coche extends Vehiculo{
    @Min(value = 2, message = "El número de puertas debe ser al menos 2")
    private int numeroPuertas;

    public Coche(String marca, String modelo, int anho, int numeroPuertas) {
        super(marca, modelo, anho);
        this.numeroPuertas = numeroPuertas;
    }
}
