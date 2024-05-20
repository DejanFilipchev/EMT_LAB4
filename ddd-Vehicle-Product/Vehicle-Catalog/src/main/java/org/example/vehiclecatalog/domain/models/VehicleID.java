package org.example.vehiclecatalog.domain.models;

import lombok.NonNull;
import org.example.sharedkernel.domain.base.DomainObjectId;

public class VehicleID extends DomainObjectId {

    private VehicleID() {
        super(VehicleID.randomId(VehicleID.class).getId());
    }

    public VehicleID(@NonNull String uuid) {
        super(uuid);
    }

    public static VehicleID of(String uuid) {
        VehicleID p = new VehicleID(uuid);
        return p;
    }

}

