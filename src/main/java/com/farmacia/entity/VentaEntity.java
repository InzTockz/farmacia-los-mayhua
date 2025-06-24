package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaEntity {

    @Id
    @Column(name = "id_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    @Column(name = "importe_total", nullable = false)
    private double importeTotal;

    @Column(name = "fecha_creacion", nullable = false)
    @CreationTimestamp
    private LocalDate fechaCreacion;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @JoinColumn(name = "id_usuario", nullable = false)
    @ManyToOne
    private UsuarioEntity idUsuario;
}
