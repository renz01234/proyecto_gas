package com.upn.PryctV1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.upn.PryctV1.dto.ProductoDTO;
import com.upn.PryctV1.model.ProductoModel;
import com.upn.PryctV1.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService service;

    // LISTAR
    @GetMapping({"", "/", "/index", "/listar"})
    public String index(Model model) {

        List<ProductoDTO> lista = service.listar();
        model.addAttribute("lista_producto", lista);

        return "producto/index";
    }

    // INGRESAR
    @GetMapping("/ingresar")
    public String ingresar(Model model) {

        model.addAttribute("producto", new ProductoModel());

        return "producto/form-producto";
    }

    // GUARDAR
    @PostMapping("/procesar")
    public String procesar(@Validated ProductoModel p,
                           RedirectAttributes redirect) {

        service.saveProducto(p);
        redirect.addFlashAttribute("msg", "Producto guardado correctamente");

        return "redirect:/producto/listar";
    }

    // MODIFICAR
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model) {

        ProductoModel p = service.getProducto(id);
        model.addAttribute("producto", p);

        return "producto/form-producto";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id,
                           RedirectAttributes redirect) {

        service.deleteProducto(id);
        redirect.addFlashAttribute("msg", "Producto eliminado correctamente");

        return "redirect:/producto/listar";
    }

    // BUSCAR
    @GetMapping("/buscar")
    public String buscar(@RequestParam("nombre") String nombre,
                         Model model) {

        model.addAttribute("lista_producto",
                service.buscarPorNombreJPQL(nombre));

        return "producto/index";
    }
}