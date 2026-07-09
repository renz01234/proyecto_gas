package com.upn.PryctV1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.upn.PryctV1.dto.RolDTO;
import com.upn.PryctV1.model.RolModel;
import com.upn.PryctV1.service.RolService;

@Controller
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService service;

    // LISTAR
    @GetMapping({"", "/", "/index", "/listar"})
    public String index(Model model) {

        List<RolDTO> lista = service.listar();
        model.addAttribute("lista_rol", lista);

        return "rol/index";
    }

    // INGRESAR
    @GetMapping("/ingresar")
    public String ingresar(Model model) {

        model.addAttribute("rol", new RolModel());

        return "rol/form-rol";
    }

    // GUARDAR
    @PostMapping("/procesar")
    public String procesar(@Validated RolModel r,
                           RedirectAttributes redirect) {

        service.saveRol(r);
        redirect.addFlashAttribute("msg", "Rol guardado correctamente");

        return "redirect:/rol/listar";
    }

    // MODIFICAR
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model) {

        RolModel r = service.getRol(id);
        model.addAttribute("rol", r);

        return "rol/form-rol";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id,
                           RedirectAttributes redirect) {

        service.deleteRol(id);
        redirect.addFlashAttribute("msg", "Rol eliminado correctamente");

        return "redirect:/rol/listar";
    }

    // BUSCAR
    @GetMapping("/buscar")
    public String buscar(@RequestParam("nombre") String nombre,
                         Model model) {

        model.addAttribute("lista_rol",
                service.buscarPorNombreJPQL(nombre));

        return "rol/index";
    }
}