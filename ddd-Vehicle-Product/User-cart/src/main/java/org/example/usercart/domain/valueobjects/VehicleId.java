package org.example.usercart.domain.valueobjects;


import jakarta.persistence.Embeddable;
import org.example.sharedkernel.domain.base.DomainObjectId;

@Embeddable
public class VehicleId extends DomainObjectId {

    public VehicleId(String uuid) {
        super(uuid);
    }

    public VehicleId() {
        super(VehicleId.randomId(VehicleId.class).getId());
    }
}
