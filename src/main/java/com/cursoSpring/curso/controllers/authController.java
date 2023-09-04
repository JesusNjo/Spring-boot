package com.cursoSpring.curso.controllers;


import com.cursoSpring.curso.DAO.UsuarioDAO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cursoSpring.curso.models.usuario;
@RestController
public class authController {
UsuarioDAO userDao;

    @RequestMapping(value ="api/login",method = RequestMethod.POST)
    public String login(usuario user){
        if(userDao.verificarUser(user)){
            return "OK";
        }else{
            return "FAIL";
        }


    }
}
