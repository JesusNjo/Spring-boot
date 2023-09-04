package com.cursoSpring.curso.DAO;

import com.cursoSpring.curso.models.usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDAO{

    @PersistenceContext
EntityManager em;



    @Override
    public List<usuario> getUsuarios() {
    String query = "FROM usuario";
    return em.createQuery(query).getResultList();
    }

    @Override
    public void delete(Long id) {
        usuario usuario = em.find(usuario.class,id);
        em.remove(usuario);
    }

    @Override
    public void createUser(usuario user) {
        em.merge(user);
    }

    @Override
    public boolean verificarUser(usuario user) {
        String query = "FROM usuario WHERE email = :emial AND password :password";
        List<usuario> lista= em.createQuery(query).setParameter("email",user.getEmail()).setParameter("password",user.getPassword()).getResultList();

        return !lista.isEmpty();

    }
}
