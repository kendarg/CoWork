package com.CoWork.CoWork.repository;

import com.cowork.api.model.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacioRepository extends JpaRepository<Espacio, Long> {
    // No requiere código de implementación manual
}