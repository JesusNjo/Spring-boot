package com.cursoSpring.curso.controllers;

import com.cursoSpring.curso.DAO.UsuarioDAO;
import com.cursoSpring.curso.models.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class usuarioController {
    @Autowired
    UsuarioDAO UsuarioDao;
            @RequestMapping(value = "api/usuario/{id}")
            public usuario getUsuario(@PathVariable Long id){
                usuario usuarios = new usuario();
                usuarios.setId(id);
                usuarios.setNombre("Francisco");
                usuarios.setApellido("Naranjo");
                usuarios.setEmail("Naranjofjx@gmail.com");
                usuarios.setPassword("1320054");
                usuarios.setTelefono("04126643122");


                return usuarios;
    }


    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<usuario> getUsuarios() {


        return UsuarioDao.getUsuarios();
    }



    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
            public void deleteUsuario(@PathVariable Long id){

        UsuarioDao.delete(id);

    }

            @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
            public void createUsuario(@RequestBody usuario user){
                UsuarioDao.createUser(user);



    }
}
