package org.example.hn_k24_cntt3_dohongky_005.service;

import org.example.hn_k24_cntt3_dohongky_005.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getAll();
    CarDTO create(CarDTO dto);
    void delete(Long id);
}