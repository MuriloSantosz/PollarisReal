package com.senai.Pollaris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TelasController {

    @GetMapping("/modo")
    public String mostrarModo() {
        return "modo";
    }


    @GetMapping("/criancas")
    public String mostrarTelaCriancas(){
        return "Criancas";
    }
}
