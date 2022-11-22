/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haider.app_basespring.service;

import com.haider.app_basespring.entity.Producto;
import com.haider.app_basespring.entity.Usuario;
import com.haider.app_basespring.repository.ProductoRepository;
import com.haider.app_basespring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.extern.log4j.Log4j2;
/**
 *
 * @author Haider@
 */
@Service
@Log4j2
public class ProductoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public boolean createProducto(Producto producto){
        try {
            if (!productoRepository.existsByserial_producto(producto.getSerial_producto())){

                productoRepository.save(producto);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Producto> readProductos(){
        return productoRepository.findAll();
    }

    @Transactional
    public String updateProducto(Producto producto){
        if (productoRepository.existsByserial_producto(producto.getSerial_producto())){
            productoRepository.save(producto);
            return "Producto record updated.";

        }else {
            return "Producto does not exists in the database.";
        }
    }

    @Transactional
    public String deleteProducto(Producto producto){
        if (productoRepository.existsByserial_producto(producto.getSerial_producto())){
            productoRepository.delete(producto);
            return "Producto record deleted successfully.";
        }else {
            return "Producto does not exist";
        }
    }

}
