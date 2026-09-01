package com.CoWork.CoWork.service;

import com.CoWork.CoWork.*;
import com.CoWork.CoWork.repository.EspacioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspacioService {

    private final EspacioRepository espacioRepository;

    public EspacioService(EspacioRepository espacioRepository) {
        this.espacioRepository = espacioRepository;
    }

    public List<Espacio> obtenerTodos() {
        return espacioRepository.findAll();
    }

    public Optional<Espacio> obtenerPorId(Long id) {
        return espacioRepository.findById(id);
    }

    public Espacio guardar(Espacio espacio) {
        if (espacio.getCapacidad() == null || espacio.getCapacidad() <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }
        return espacioRepository.save(espacio);
    }

    public Optional<Espacio> actualizar(Long id, Espacio espacio) {
        if (espacio.getCapacidad() == null || espacio.getCapacidad() <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }
        return espacioRepository.update(id, espacio);
    }

    public boolean eliminar(Long id) {
        return espacioRepository.deleteById(id);
    }

    public List<Espacio> buscarPorCategoria(String categoria) {
        return espacioRepository.findByCategoria(categoria);
    }
}