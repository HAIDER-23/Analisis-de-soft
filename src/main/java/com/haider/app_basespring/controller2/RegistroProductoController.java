package com.haider.app_basespring.controller2;

import com.haider.app_basespring.entity.Producto;
import com.haider.app_basespring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    /**
     *
     * @author Haider
     */
    @Controller
    @RequestMapping("/registroProducto")
    public class RegistroProductoController {
        @Autowired
        ProductoService ProductoService;

        @PostMapping
        public String registrarProducto(@ModelAttribute("producto") Producto productoDTO) {

            if (ProductoService.createProducto(productoDTO)){
                System.out.println(productoDTO);
                return "redirect:/registro?exito";
            }
            return "redirect:/registro?error";

        }

        @ModelAttribute("producto")
        public Producto retornarNuevoProductoRegustro() {
            return new Producto();
        }

        @GetMapping
        public String getRegistroProducto() {
            return "registroProducto";
        }
    }


