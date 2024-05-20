package org.example.usercart.domain.models;

import lombok.NonNull;
import org.example.sharedkernel.domain.base.DomainObject;
import org.example.sharedkernel.domain.base.DomainObjectId;

public class OrderId extends DomainObjectId {

    private OrderId() {
        super(OrderId.randomId(OrderId.class).getId());
    }

    public OrderId(@NonNull String uuid) {
        super(uuid);
    }

}
