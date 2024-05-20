package org.example.vehiclecatalog.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import org.example.sharedkernel.domain.base.AbstractEntity;
import org.example.vehiclecatalog.domain.valueobjects.Money;

import java.util.Date;

@Entity
@Table(name = "vehicle")
@Getter
public class Vehicle extends AbstractEntity<VehicleID> {

    private String serialNumber;

    private String model;

    private Date yearOfProduction;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Money price;

    private int sales = 0;

    public Vehicle() {
        super(VehicleID.randomId(VehicleID.class));
    }

    public static Vehicle build(String serialNumber, String model, Date yearOfProduction, Type type, Money money, int sales){
        Vehicle v = new Vehicle();
        v.serialNumber = serialNumber;
        v.model = model;
        v.yearOfProduction = yearOfProduction;
        v.type = type;
        v.price = money;
        v.sales = sales;
        return v;
    }

    public void addSales(int qty){
        this.sales += qty;
    }

    public void removeSales(int qty){
        this.sales -= qty;
    }
}
