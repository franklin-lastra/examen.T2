package com.examenT2.LP2_T2_Lastra_Franklin.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examenT2.LP2_T2_Lastra_Franklin.model.OrdenCompraLastraFranklin;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompraLastraFranklin, Integer> {
    
  
    List<OrdenCompraLastraFranklin> findAllByOrderByNroOrdenDesc();
}