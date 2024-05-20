package org.example.usercart.domain.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import org.example.sharedkernel.domain.base.AbstractEntity;
import org.example.sharedkernel.domain.base.DomainObjectId;
import org.example.usercart.domain.valueobjects.VehicleId;
import org.example.vehiclecatalog.domain.models.Vehicle;
import org.example.vehiclecatalog.domain.valueobjects.Money;

@Entity
@Table(name = "shopping_cart")
@Getter
public class Shopping_cart extends AbstractEntity<Shopping_cartId> {

    @Column(name = "serial_number", nullable = false)
    private String serial_number;

    private Money sum;

    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name = "id", column = @Column(name = "vehicle_id", nullable = false))
    private VehicleId vehicleId;


    public Shopping_cart(@NonNull VehicleId vehicleId,@NonNull Money sum, int qty){
        super(DomainObjectId.randomId(Shopping_cartId.class));
        this.vehicleId=vehicleId;
        this.sum=sum;
        this.quantity=qty;
    }

    public Shopping_cart() {

    }


    public Money subTotal(){
        return sum.multiply(quantity);
    }


}
