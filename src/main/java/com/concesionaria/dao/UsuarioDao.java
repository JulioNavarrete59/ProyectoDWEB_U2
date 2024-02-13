package com.concesionaria.dao;

import com.concesionaria.modelo.JPAUtil;
import com.concesionaria.modelo.usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UsuarioDao {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    public void registrar(usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
    }

    public usuario buscarPorUsername(String username) {
        TypedQuery<usuario> query = entityManager.createQuery("SELECT u FROM usuario u WHERE u.username = :username", usuario.class);
        query.setParameter("username", username);

        List<usuario> resultList = query.getResultList();

        if (resultList.isEmpty()) {
            // No se encontró ningún usuario con el nombre de usuario proporcionado
            return null;
        } else {
            // Devuelve el primer usuario de la lista (puede haber solo uno debido a la unicidad del nombre de usuario)
            return resultList.get(0);
        }
    }

    public void actualizar(usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
    }

}
