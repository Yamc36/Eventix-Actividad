package com.eventix.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class eventixModel {

    private Long id;

    @NotBlank(message = "El nombre o descripción no puede estar vacío")
    private String name;

    @NotBlank(message = "El tipo de evento es obligatorio")
    private String type;

    @NotNull(message = "La fecha de realización es obligatoria")
    private String date;

    @NotBlank(message = "La ubicación es obligatoria")
    private String location;

    @Min(value = 1, message = "La capacidad debe ser al menos de 1 participante")
    private int capacity;
}  