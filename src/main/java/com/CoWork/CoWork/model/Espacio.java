package com.CoWork.CoWork.model;

public class Espacio {
    private Long id;
    private String nombre;
    private Integer capacidad;
    private Double precioHora;
    private String descripcion;
    private String nombreCategoria;
    private String nombreSede;

    public Espacio() {
    }

    public Espacio(Long id, String nombre, Integer capacidad, Double precioHora, String descripcion, String nombreCategoria, String nombreSede) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioHora = precioHora;
        this.descripcion = descripcion;
        this.nombreCategoria = nombreCategoria;
        this.nombreSede = nombreSede;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(Double precioHora) {
        this.precioHora = precioHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }
}
