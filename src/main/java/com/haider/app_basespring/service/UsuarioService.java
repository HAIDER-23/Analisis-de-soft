/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haider.app_basespring.service;

import com.haider.app_basespring.entity.Usuario;
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
public class UsuarioService {
    
    @PersistenceContext
    private EntityManager entityManager;
        
    @Autowired
    private UsuarioRepository usuarioRepository;
    
      @Transactional
    public boolean createUsuario(Usuario usuario){
        try {
            if (!usuarioRepository.existsByCedula(usuario.getCedula())){
                
                usuarioRepository.save(usuario);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Usuario> readUsuarios(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public String updateUsuario(Usuario usuario){
        if (usuarioRepository.existsByCedula(usuario.getCedula())){
             usuarioRepository.save(usuario);
                return "Usuario record updated.";
            
        }else {
            return "Usuario does not exists in the database.";
        }
    }

    @Transactional
    public String deleteUsuario(Usuario usuario){
        if (usuarioRepository.existsByCedula(usuario.getCedula())){
            usuarioRepository.delete(usuario);
            return "Usuario record deleted successfully.";
        }else {
            return "Usuario does not exist";
        }
    }
    public boolean autenticar(Usuario usuario){
     Usuario usuarioN = usuarioRepository.findByEmail(usuario.getEmail());
     if (usuario.getEmail().equals(usuarioN.getEmail()) && 
         usuario.getClave().equals(usuarioN.getClave())){
         return true; 
     }
     return false;
    }
    public boolean autenticarX(Usuario usuario){
        String sql = "select  e from Usuario where e.email = :email and e.clave = :clave";
        Query q = entityManager.createQuery(sql);
        q.setParameter("email", usuario.getEmail());
        q.setParameter("clave", usuario.getClave());
        try {
            usuario = (Usuario)q.getSingleResult();
            if (usuario != null){
                return true;
            }
        }catch (Exception e ){
            log.error("No se encuentra el usuario", e);
        }
                    
        return false;
    }
}
