package org.example.hn_k24_cntt3_dohongky_005.dto;

import org.example.hn_k24_cntt3_dohongky_005.entity.CarStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarDTO {
    private Long id;

    @NotBlank(message = "Model không được để trống")
    private String model;

    @NotBlank(message = "Brand không được để trống")
    private String brand;

    @NotNull(message = "Price không được để trống")
    @Min(value = 1, message = "Price phải lớn hơn 0")
    private Double price;

    @NotNull(message = "Status không được để trống")
    private CarStatus status;
}