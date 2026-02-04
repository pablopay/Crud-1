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
@DiscriminatorValue("MOTO") // Valor para distinguir esta subclase en la tabla de Vehiculo
public class Motocicleta extends Vehiculo {
    @Min(value=1, message = "La cilindrada debe ser al menos 1 cc")
    private int cc;

    public Motocicleta(String marca, String modelo, int anho, int cc) {
        super(marca, modelo, anho);
        this.cc = cc;
    }
}
