package com.farmacia.repository;

import com.farmacia.entity.CategoriaProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaProductoRepository extends JpaRepository<CategoriaProductoEntity, Long> {
}
