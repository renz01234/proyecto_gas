package com.upn.PryctV1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.upn.PryctV1.model.UsuarioModel;
import com.upn.PryctV1.service.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService service;

    // Mostrar Login
    @GetMapping("/")
    public String login() {
        return "login";
    }

    // Procesar Login
    @PostMapping("/login")
    public String iniciarSesion(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                Model model) {

        UsuarioModel usuario = service.buscarPorEmail(email);

        // Verificar si existe
        if (usuario == null) {
            model.addAttribute("error", "El usuario no existe");
            return "login";
        }

        // Verificar contraseña
        if (!usuario.getPassword().equals(password)) {
            model.addAttribute("error", "Contraseña incorrecta");
            return "login";
        }

        // Verificar si está activo
        if (!usuario.isActivo()) {
            model.addAttribute("error", "Usuario deshabilitado");
            return "login";
        }

        // Redirigir según el rol
        switch (usuario.getRol().getCodRol()) {

            case 1:
                return "redirect:/producto/listar";

            case 2:
                return "redirect:/repartidor";

            case 3:
                return "redirect:/cliente";

            default:
                model.addAttribute("error", "Rol inválido");
                return "login";
        }

    }

}