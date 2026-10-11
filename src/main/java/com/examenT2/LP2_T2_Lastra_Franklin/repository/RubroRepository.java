package com.examenT2.LP2_T2_Lastra_Franklin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examenT2.LP2_T2_Lastra_Franklin.model.RubroLastraFranklin;

@Repository
public interface RubroRepository extends JpaRepository<RubroLastraFranklin, Integer> {
}