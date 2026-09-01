package com.CoWork.CoWork.service;

import com.CoWork.CoWork.model.Espacio;
import com.CoWork.CoWork.repository.EspacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EspacioService {

    @Autowired
    private EspacioRepository espacioRepository;

    public List<Espacio> obtenerTodos() {
        return espacioRepository.findAll();
    }

    public Optional<Espacio> obtenerPorId(Long id) {
        return espacioRepository.findById(id);
    }

    public Espacio crear(Espacio espacio) {
        return espacioRepository.save(espacio);
    }

    public Optional<Espacio> actualizar(Long id, Espacio espacioDetalles) {
        return espacioRepository.findById(id).map(espacioExistente -> {
            espacioExistente.setNombre(espacioDetalles.getNombre());
            espacioExistente.setCapacidad(espacioDetalles.getCapacidad());
            espacioExistente.setPrecioHora(espacioDetalles.getPrecioHora());
            espacioExistente.setNombreCategoria(espacioDetalles.getNombreCategoria());
            espacioExistente.setNombreSede(espacioDetalles.getNombreSede());
            return espacioRepository.save(espacioExistente);
        });
    }

    public boolean eliminar(Long id) {
        if (espacioRepository.existsById(id)) {
            espacioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}