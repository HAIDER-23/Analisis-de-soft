package com.haider.app_basespring.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
;


import com.haider.app_basespring.service.UsuarioService;
import com.haider.app_basespring.entity.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Haider
 */
@Controller
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuarioDTO) {
        
        if (usuarioService.createUsuario(usuarioDTO)){
            System.out.println(usuarioDTO);
            return "redirect:/registro?exito";
        }
        return "redirect:/registro?error";

    }

    @ModelAttribute("usuario")
    public Usuario retornarNuevoUsuarioRegistroDTO() {
            return new Usuario();
    }
        
    @GetMapping
    public String getRegistro() {
        return "registro";
    }
}
