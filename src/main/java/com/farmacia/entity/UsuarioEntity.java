package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombres_usuario", nullable = false)
    private String nombreUsuario;

    @Column(name = "correo", nullable = false, length = 150)
    private String correo;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "roles", nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles roles;

    @Column(name = "estado", nullable = false)
    private boolean estado;
}
