package com.concesionaria.dao;

import com.concesionaria.idao.IVentasDao;
import com.concesionaria.modelo.JPAUtil;
import com.concesionaria.modelo.ventas;
import jakarta.persistence.EntityManager;

import java.util.List;

public class VentasImpl implements IVentasDao {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
@Override
    public void registrar(ventas ventas) {
        entityManager.getTransaction().begin();
        entityManager.persist(ventas);
        entityManager.getTransaction().commit();
    }

    @Override
    public void modificar(ventas ventas) {
        entityManager.getTransaction().begin();
        entityManager.merge(ventas);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        ventas venta;
        venta = entityManager.find(ventas.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(venta);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<ventas> obtenerVentas() {
        List<ventas> listaVentas;
        listaVentas = entityManager.createQuery("SELECT v FROM ventas v").getResultList();
        return listaVentas;
    }

    @Override
    public ventas obtenerVentasPorId(int id) {
        ventas venta;
        venta = entityManager.find(ventas.class, id);
        return venta;
    }
}
