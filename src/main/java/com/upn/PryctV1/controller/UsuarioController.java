package com.upn.PryctV1.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.upn.PryctV1.dto.UsuarioDTO;
import com.upn.PryctV1.model.UsuarioModel;
import com.upn.PryctV1.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // LISTAR
    @GetMapping({"", "/", "/index", "/listar"})
    public String index(Model model) {

        List<UsuarioDTO> lista = service.listar();
        model.addAttribute("lista_usuario", lista);

        return "usuario/index";
    }

    // INGRESAR
    @GetMapping("/ingresar")
    public String ingresar(Model model) {

        model.addAttribute("usuario", new UsuarioModel());

        return "usuario/form-usuario";
    }

    // GUARDAR
    @PostMapping("/procesar")
    public String procesar(@Valid UsuarioModel u,
                           BindingResult result,
                           RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "usuario/form-usuario";
        }

        service.saveUsuario(u);

        redirect.addFlashAttribute("msg", "Usuario guardado correctamente");

        return "redirect:/usuario/listar";
    }

    // MODIFICAR
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model) {

        UsuarioModel u = service.getUsuario(id);
        model.addAttribute("usuario", u);

        return "usuario/form-usuario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id,
                           RedirectAttributes redirect) {

        service.deleteUsuario(id);
        redirect.addFlashAttribute("msg", "Usuario eliminado correctamente");

        return "redirect:/usuario/listar";
    }

    // BUSCAR
    @GetMapping("/buscar")
    public String buscar(@RequestParam("nombre") String nombre,
                         Model model) {

        model.addAttribute("lista_usuario",
                service.buscarPorNombreJPQL(nombre));

        return "usuario/index";
    }

}