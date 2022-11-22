package testApp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.github.javafaker.Faker;
import com.haider.app_basespring.entity.Producto;
import com.haider.app_basespring.entity.Usuario;
import com.haider.app_basespring.service.UsuarioService;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


/**
 *
 * @author Haider@
 */
@SpringBootTest
@ActiveProfiles("test") 
public class PruebasTest {
    
    @Autowired
    private UsuarioService usuarioService;
    private UsuarioService productoService;
    @Test
    public void TestEjemploNull() {
        Faker faker = new Faker();
        String nombre = faker.name().name();

        assertFalse(nombre.length() == 0);

    }

    @Test
    public void testService() {
        Faker faker = new Faker();
        String nombre = faker.name().name();
        List<Usuario> lista = usuarioService.readUsuarios();

        assertTrue(lista.size() >0);

    }
}
