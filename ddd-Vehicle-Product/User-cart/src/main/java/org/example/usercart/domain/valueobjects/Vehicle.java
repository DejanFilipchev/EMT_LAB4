package org.example.usercart.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.sharedkernel.domain.base.ValueObjects;
import org.example.vehiclecatalog.domain.models.VehicleID;
import org.example.vehiclecatalog.domain.valueobjects.Currency;
import org.example.vehiclecatalog.domain.valueobjects.Money;

@Getter
public class Vehicle implements ValueObjects {

    private final VehicleId id;
    private final String name;
    private final Money price;

    private Vehicle() {
        this.id= VehicleId.randomId(VehicleId.class);
        this.name= "";
        this.price = Money.valueOf(Currency.MKD,0);
    }

    @JsonCreator
    public Vehicle(@JsonProperty("id") VehicleId id,
                   @JsonProperty("productName") String name,
                   @JsonProperty("price") Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
