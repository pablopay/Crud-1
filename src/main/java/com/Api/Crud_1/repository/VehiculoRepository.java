package com.Api.Crud_1.repository;

import com.Api.Crud_1.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
