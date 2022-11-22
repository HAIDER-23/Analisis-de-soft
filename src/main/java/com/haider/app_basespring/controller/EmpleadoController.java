package com.haider.app_basespring.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Haider@
 */
@Controller
public class EmpleadoController {
    
    @RequestMapping("/consultar")
    public String consultar() {
         
        return "mensaje";
    }
    
    @RequestMapping("/guardar")
    public String guardar() {
         
        return "mensaje";
    }
    @RequestMapping(value="/crear", method = RequestMethod.GET)
    public String showCrearPage(ModelMap model){
        return "crear";
    }
    
    
}
