package org.example.hn_k24_cntt3_dohongky_005.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.hn_k24_cntt3_dohongky_005.entity.CarStatus;

@Entity
@Table(name = "cars")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String brand;
    private Double price;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
}