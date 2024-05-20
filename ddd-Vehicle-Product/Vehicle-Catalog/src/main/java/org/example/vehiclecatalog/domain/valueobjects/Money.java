package org.example.vehiclecatalog.domain.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;

@Embeddable
@Getter
public class Money {

    private final int amount;

    @Enumerated(value = EnumType.STRING)
    private final org.example.vehiclecatalog.domain.valueobjects.Currency currency;

    protected Money(){
        this.amount = 0;
        this.currency = null;
    }

    public Money(@NonNull org.example.vehiclecatalog.domain.valueobjects.Currency currency, @NonNull int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public static Money valueOf(Currency currency, int amount) {
        return new Money(currency,amount);
    }

    public Money add(Money money) {
        if (!currency.equals(money.currency)) {
            throw new RuntimeException("Cannot add two Money objects with different currencies");
        }
        return new Money(currency,amount + money.amount);
    }

    public Money subtract(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }
        return new Money(currency,amount - money.amount);
    }

    public Money multiply(int m)  {
        return new Money(currency,amount*m);
    }



}
