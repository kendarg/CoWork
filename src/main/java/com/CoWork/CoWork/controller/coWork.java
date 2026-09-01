package com.CoWork.CoWork.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ingreso")
public class coWork {
    @GetMapping("/Informacion")
    public String Informacion(){
    return "Esta es una prueva de como se ven los datos con Sprinboot y como los capta usando RestController, RequestMapping y GetMapping";
}
}
