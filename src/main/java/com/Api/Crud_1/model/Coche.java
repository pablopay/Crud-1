package com.Api.Crud_1.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("COCHE") // Valor para distinguir esta subclase en la tabla de Vehiculo
public class Coche extends Vehiculo{
    private int numeroPuertas;

    public Coche(String marca, String modelo, int anho, int numeroPuertas) {
        super(marca, modelo, anho);
        this.numeroPuertas = numeroPuertas;
    }
}
