package org.example.vehiclecatalog.service.form;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.example.vehiclecatalog.domain.models.Type;
import org.example.vehiclecatalog.domain.valueobjects.Money;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class VehicleForm {

    @NotNull
    private String VehicleName;

    @Min(0)
    private Money price;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Min(0)
    private int sales;

    @Valid
    @NotEmpty
    private String serialnumber;

    @Valid
    @NotEmpty
    private String model;

    @DateTimeFormat
    private Date yearOfProduction;
}
