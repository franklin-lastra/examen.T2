package com.examenT2.LP2_T2_Lastra_Franklin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Lastra_Franklin.model.OrdenCompraLastraFranklin;
import com.examenT2.LP2_T2_Lastra_Franklin.model.ProveedorLastraFranklin;
import com.examenT2.LP2_T2_Lastra_Franklin.repository.OrdenCompraRepository;
import com.examenT2.LP2_T2_Lastra_Franklin.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final OrdenCompraRepository ordenCompraRepository;
    private final ProveedorRepository proveedorRepository;

    // 1. Listar proveedores para el combo desplegable del formulario
    public List<ProveedorLastraFranklin> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    // 2. Listar órdenes de compra en orden descendente (el registro nuevo al comienzo)
    public List<OrdenCompraLastraFranklin> getAllOrdenesDesc() {
        return ordenCompraRepository.findAllByOrderByNroOrdenDesc();
    }

    // 3. Registrar una nueva orden de compra de forma real en MySQL
    public OrdenCompraLastraFranklin registrar(OrdenCompraLastraFranklin orden) {
        return ordenCompraRepository.save(orden);
    }

    // 4. Buscar una orden de compra por su ID para la edición
    public OrdenCompraLastraFranklin getOne(Integer id) {
        return ordenCompraRepository.findById(id).orElse(null);
    }

    // 5. Actualizar los cambios de una orden editada
    public OrdenCompraLastraFranklin update(OrdenCompraLastraFranklin orden) {
        return ordenCompraRepository.save(orden);
    }
}