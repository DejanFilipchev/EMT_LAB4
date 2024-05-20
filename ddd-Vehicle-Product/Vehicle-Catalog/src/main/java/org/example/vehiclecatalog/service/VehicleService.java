package org.example.vehiclecatalog.service;

import org.example.vehiclecatalog.domain.models.Vehicle;
import org.example.vehiclecatalog.domain.models.VehicleID;
import org.example.vehiclecatalog.service.form.VehicleForm;

import java.util.List;

public interface VehicleService {

    Vehicle findById(VehicleID id);

    List<Vehicle> findAll();

    Vehicle createVehicle(VehicleForm vehicleForm);

    Vehicle orderItemCreate(VehicleID vehicleID, int quantity);

    Vehicle orderItemRemove(VehicleID vehicleID, int quantity);
}
