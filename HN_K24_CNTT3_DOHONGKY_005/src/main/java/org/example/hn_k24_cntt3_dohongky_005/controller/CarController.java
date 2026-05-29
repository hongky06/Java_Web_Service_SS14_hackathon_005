package org.example.hn_k24_cntt3_dohongky_005.controller;

import org.example.hn_k24_cntt3_dohongky_005.dto.CarDTO;
import org.example.hn_k24_cntt3_dohongky_005.entity.Car;
import org.example.hn_k24_cntt3_dohongky_005.repository.CarRepository;
import org.example.hn_k24_cntt3_dohongky_005.service.CarService; // Bổ sung import Service để dùng thay vì gọi trực tiếp Repository

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAll() {
        List<CarDTO> list = carRepository.findAll().stream().map(car -> {
            CarDTO dto = new CarDTO();
            dto.setId(car.getId());
            dto.setModel(car.getModel());
            dto.setBrand(car.getBrand());
            dto.setPrice(car.getPrice());
            dto.setStatus(car.getStatus());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<CarDTO> create(@Valid @RequestBody CarDTO dto) {
        Car car = new Car();
        car.setModel(dto.getModel());
        car.setBrand(dto.getBrand());
        car.setPrice(dto.getPrice());
        car.setStatus(dto.getStatus());

        Car saved = carRepository.save(car);
        dto.setId(saved.getId());
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy xe với ID: " + id));
        carRepository.delete(car);
        return ResponseEntity.noContent().build();
    }
}