package com.haider.app_basespring.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import com.haider.app_basespring.entity.Usuario;
import com.haider.app_basespring.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Haider
 */
@Controller
public class AutenticarController {
    @Autowired UsuarioService usuarioService;
    
    
    @GetMapping("/autenticar")
    public String getAutenticar() {
        return "autenticar";
    }
    
    @GetMapping("/autenticarOK")
    public String verPaginaDeInicio(Model modelo) {
        System.out.println("Modelo ");
        System.out.println(modelo.getAttribute("username"));
        
        List<Usuario> usuarios = usuarioService.readUsuarios();
        modelo.addAttribute("usuarios", usuarios);
            //modelo.addAttribute("usuarios", servicioUsuario.ConsultaTodos());
        return "index";
    }
    
    @PostMapping("/autenticar")
    public String autenticar(@ModelAttribute("usuario") Usuario  usuarioDTO) {
        
        if (!usuarioService.autenticar(usuarioDTO)) {
            System.out.println(usuarioDTO);
            return "redirect:/autenticar?error";

        }
        return "redirect:/autenticarOK";
            
            
    }
    
}
