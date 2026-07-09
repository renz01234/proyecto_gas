package com.upn.PryctV1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.upn.PryctV1.model.ClienteModel;
import com.upn.PryctV1.model.RolModel;
import com.upn.PryctV1.model.UsuarioModel;
import com.upn.PryctV1.service.ClienteService;
import com.upn.PryctV1.service.RolService;
import com.upn.PryctV1.service.UsuarioService;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private RolService rolService;

    @Autowired
    private ClienteService clienteService;

    // Código de rol "Cliente" según el import.sql (ROL: Administrador=1, Repartidor=2, Cliente=3)
    private static final int COD_ROL_CLIENTE = 3;

    // Mostrar formulario de registro
    @GetMapping("/registro")
    public String registro(Model model) {

        model.addAttribute("usuario", new UsuarioModel());

        return "registro";
    }

    // Guardar nuevo cliente
    @PostMapping("/registro")
    public String guardar(@ModelAttribute UsuarioModel usuario,
                          @RequestParam("celular") String celular,
                          @RequestParam("direccion") String direccion,
                          Model model) {

        // Asignar automáticamente el rol Cliente
        RolModel rolCliente = rolService.getRol(COD_ROL_CLIENTE);
        usuario.setRol(rolCliente);

        // Activar usuario
        usuario.setActivo(true);

        UsuarioModel usuarioGuardado = service.saveUsuario(usuario);

        // Crear el perfil de Cliente asociado a este usuario
        ClienteModel cliente = new ClienteModel();
        cliente.setUsuario(usuarioGuardado);
        cliente.setCelular(celular);
        cliente.setDireccion(direccion);
        clienteService.saveCliente(cliente);

        model.addAttribute("mensaje",
                "Cuenta creada correctamente.");

        return "redirect:/";
    }

}