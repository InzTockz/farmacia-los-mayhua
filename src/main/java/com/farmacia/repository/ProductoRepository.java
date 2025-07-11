package com.farmacia.repository;

import com.farmacia.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    @Query(" SELECT p " +
            "FROM ProductoEntity p " +
            "WHERE p.estado = true")
    List<ProductoEntity> findAll();
}
