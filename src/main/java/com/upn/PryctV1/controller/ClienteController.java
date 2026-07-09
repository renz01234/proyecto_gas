package com.upn.PryctV1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.upn.PryctV1.service.ProductoService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ProductoService productoService;

    @GetMapping({"", "/", "/index"})
    public String index(Model model) {

        model.addAttribute("lista_producto",
                productoService.listar());

        return "cliente/index";
    }

}
