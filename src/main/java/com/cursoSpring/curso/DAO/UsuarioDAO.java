package com.cursoSpring.curso.DAO;

import com.cursoSpring.curso.models.usuario;

import java.util.List;

public interface UsuarioDAO {

    public List<usuario> getUsuarios();

    public void delete(Long id);

    public void createUser(usuario user);

    public boolean verificarUser(usuario user);
}
