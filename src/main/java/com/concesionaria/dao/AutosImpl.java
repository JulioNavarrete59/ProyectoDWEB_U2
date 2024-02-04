package com.concesionaria.dao;

import com.concesionaria.idao.IAutosDao;
import com.concesionaria.modelo.JPAUtil;
import com.concesionaria.modelo.autos;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AutosImpl implements IAutosDao {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void registrar(autos autos) {
        entityManager.getTransaction().begin();
        entityManager.persist(autos);
        entityManager.getTransaction().commit();
    }

    @Override
    public void modificar(autos autos) {
        entityManager.getTransaction().begin();
        entityManager.merge(autos);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        autos auto;
        auto = entityManager.find(autos.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(auto);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<autos> obtenerAutos() {
        List<autos> listaAutos;
        listaAutos = entityManager.createQuery("SELECT a FROM autos a").getResultList();
        return listaAutos;
    }

    @Override
    public autos obtenerAutosPorId(int id) {
        autos auto;
        auto = entityManager.find(autos.class, id);
        return auto;
    }
}
