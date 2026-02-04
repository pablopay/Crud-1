package com.Api.Crud_1.exception;

public class VehiculoNotFoundException extends RuntimeException{
    // Excepción personalizada para manejar casos donde un vehículo no es encontrado
    // creamela clase con un constructor que reciba un mensaje y lo pase a la clase padre Exception
    public VehiculoNotFoundException(String message) {
        super(message);
    }
}
