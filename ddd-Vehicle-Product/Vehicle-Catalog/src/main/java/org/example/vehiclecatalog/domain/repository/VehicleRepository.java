package org.example.vehiclecatalog.domain.repository;

import org.example.vehiclecatalog.domain.models.Vehicle;
import org.example.vehiclecatalog.domain.models.VehicleID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, VehicleID> {
}
