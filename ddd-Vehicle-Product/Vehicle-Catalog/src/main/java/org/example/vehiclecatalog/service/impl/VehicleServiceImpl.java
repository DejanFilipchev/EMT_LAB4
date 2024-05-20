package org.example.vehiclecatalog.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.vehiclecatalog.domain.models.Vehicle;
import org.example.vehiclecatalog.domain.models.VehicleID;
import org.example.vehiclecatalog.domain.repository.VehicleRepository;
import org.example.vehiclecatalog.service.VehicleService;
import org.example.vehiclecatalog.service.form.VehicleForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle findById(VehicleID id) {
        return vehicleRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle createVehicle(VehicleForm vehicleForm) {
        Vehicle vehicle = Vehicle.build(vehicleForm.getSerialnumber(),vehicleForm.getModel(),vehicleForm.getYearOfProduction(),vehicleForm.getType(),vehicleForm.getPrice(),vehicleForm.getSales());
        vehicleRepository.save(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle orderItemCreate(VehicleID vehicleID, int quantity) {
        Vehicle v = vehicleRepository.findById(vehicleID).orElseThrow(RuntimeException::new);
        v.addSales(quantity);
        vehicleRepository.save(v);
        return v;
    }

    @Override
    public Vehicle orderItemRemove(VehicleID vehicleID, int quantity) {
        Vehicle v = vehicleRepository.findById(vehicleID).orElseThrow(RuntimeException::new);
        v.removeSales(quantity);
        vehicleRepository.saveAndFlush(v);
        return v;
    }
}
