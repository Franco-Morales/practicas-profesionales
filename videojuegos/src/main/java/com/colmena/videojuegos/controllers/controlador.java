package com.colmena.videojuegos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controlador {
    @GetMapping(value = "/")
    public String index(Model model) {
        String saludo = "Hola Thymeleaf";
        model.addAttribute("saludo", saludo);
        return "index";
    }
}
