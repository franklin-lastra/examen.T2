package com.examenT2.LP2_T2_Lastra_Franklin.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_orden_compra")
@Data
public class OrdenCompraLastraFranklin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_orden")
    private Integer nroOrden;

    // Relación ManyToOne: id_proveedor (fk de Proveedor)
    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private ProveedorLastraFranklin proveedor;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "direccion_entrega")
    private String direccionEntrega;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(name = "estado")
    private String estado = "P"; 
}
