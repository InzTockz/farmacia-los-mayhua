package com.farmacia.repository;

import com.farmacia.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query("SELECT u " +
            "FROM UsuarioEntity u " +
            "WHERE u.estado = true")
    List<UsuarioEntity> findAll();
}
