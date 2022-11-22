/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haider.app_basespring.repository;

import com.haider.app_basespring.entity.Producto;
import com.haider.app_basespring.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Haider@
 */
@Repository
public interface  ProductoRepository extends JpaRepository<Producto, Integer>  {
    public boolean existsByserial_producto(Long serial_producto);


}
