package org.example.usercart.service.forms;


import lombok.Data;
import org.example.usercart.domain.valueobjects.Vehicle;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemForm {

    @NotNull
    private Vehicle vehicle;

    @Min(1)
    private int quantity = 1;
}
