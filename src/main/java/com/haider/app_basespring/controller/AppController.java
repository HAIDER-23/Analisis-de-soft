/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haider.app_basespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Haider
 */
@Controller
public class AppController {
    @GetMapping
    public String iniciar(){
        return "index";
    }
    
    @GetMapping("/index")
    public String iniciarI(){
        return "index";
    }

}
