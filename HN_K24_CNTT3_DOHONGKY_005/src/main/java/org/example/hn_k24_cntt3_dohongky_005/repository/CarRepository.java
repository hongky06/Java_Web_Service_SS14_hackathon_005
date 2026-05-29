package org.example.hn_k24_cntt3_dohongky_005.repository;
import org.example.hn_k24_cntt3_dohongky_005.entity.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    // Chỉ lấy những xe chưa bị xóa mềm
    @Query("SELECT c FROM Car c WHERE c.isDeleted = false")
    List<Car> findAllActive();

    // Tìm xe theo ID nhưng phải chưa bị xóa mềm
    @Query("SELECT c FROM Car c WHERE c.id = :id AND c.isDeleted = false")
    Optional<Car> findByIdActive(@Param("id") Long id);
}