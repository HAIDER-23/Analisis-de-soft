/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haider.app_basespring.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Haider@
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto implements Serializable {

    @Id
    private Long serial_producto;

    private String nombre;
    private float precio;
    private int cantidad;


}
