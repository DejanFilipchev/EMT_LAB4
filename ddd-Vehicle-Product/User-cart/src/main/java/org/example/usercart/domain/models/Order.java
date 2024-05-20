package org.example.usercart.domain.models;

import jakarta.persistence.*;
import lombok.NonNull;
import org.example.sharedkernel.domain.base.AbstractEntity;
import org.example.usercart.domain.valueobjects.Vehicle;
import org.example.vehiclecatalog.domain.valueobjects.Currency;
import org.example.vehiclecatalog.domain.valueobjects.Money;
import org.hibernate.annotations.Cascade;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity<OrderId> {


    private Instant ordered_On;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)

    private Order_state orderState;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<Shopping_cart> shoppingCartList;

    public Order(){
        super(OrderId.randomId(OrderId.class));
    }

    public Order(Instant now, org.example.vehiclecatalog.domain.valueobjects.Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.currency = currency;
    }

    public Money total(){
        return shoppingCartList.stream().map(Shopping_cart::subTotal).reduce(new Money(currency,0),Money::add);
    }

    public Shopping_cart addItem(@NonNull Vehicle vehicle, int qty) {
        Objects.requireNonNull(vehicle,"product must not be null");
        var item  = new Shopping_cart(vehicle.getId(),vehicle.getPrice(),qty);
        shoppingCartList.add(item);
        return item;
    }

    public void removeItem(@NonNull Shopping_cartId shoppingCartId) {
        Objects.requireNonNull(shoppingCartId,"Order Item must not be null");
        shoppingCartList.removeIf(v->v.getId().equals(shoppingCartId));
    }


}
