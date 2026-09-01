package com.CoWork.CoWork.repository;

import com.CoWork.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class EspacioRepository {

    private final List<Espacio> espacios = new ArrayList<>();
    private final AtomicLong secuestroId = new AtomicLong(1);

    public List<Espacio> findAll() {
        return espacios;
    }

    public Optional<Espacio> findById(Long id) {
        return espacios.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public Espacio save(Espacio espacio) {
        espacio.setId(secuestroId.getAndIncrement());
        espacios.add(espacio);
        return espacio;
    }

    public Optional<Espacio> update(Long id, Espacio espacioActualizado) {
        return findById(id).map(espacioExistente -> {
            espacioExistente.setNombre(espacioActualizado.getNombre());
            espacioExistente.setCapacidad(espacioActualizado.getCapacidad());
            espacioExistente.setPrecioHora(espacioActualizado.getPrecioHora());
            espacioExistente.setDescripcion(espacioActualizado.getDescripcion());
            espacioExistente.setNombreCategoria(espacioActualizado.getNombreCategoria());
            espacioExistente.setNombreSede(espacioActualizado.getNombreSede());
            return espacioExistente;
        });
    }

    public boolean deleteById(Long id) {
        return espacios.removeIf(e -> e.getId().equals(id));
    }

    public List<Espacio> findByCategoria(String categoria) {
        return espacios.stream()
                .filter(e -> e.getNombreCategoria() != null &&
                        e.getNombreCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }
}