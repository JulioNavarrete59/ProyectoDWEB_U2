package com.concesionaria.dao;

import com.concesionaria.idao.IDetalleVentaDao;
import com.concesionaria.modelo.JPAUtil;
import com.concesionaria.modelo.detalleVenta;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DetalleVentaImpl implements IDetalleVentaDao {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void guardarDetalleVenta(detalleVenta detalleVenta) {
        entityManager.getTransaction().begin();
        entityManager.persist(detalleVenta);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<detalleVenta> obtenerDetallesVenta() {
        List<detalleVenta> listaDetalleVenta;
        listaDetalleVenta = entityManager.createQuery("SELECT d FROM detalleVenta d").getResultList();
        return listaDetalleVenta;
    }

    @Override
    public void eliminarDetalleVenta(int idDetalleVenta) {
        detalleVenta detalleVenta;
        detalleVenta = entityManager.find(detalleVenta.class, idDetalleVenta);
        entityManager.remove(detalleVenta);
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizarDetalleVenta(detalleVenta detalleVenta) {
        entityManager.getTransaction().begin();
        entityManager.merge(detalleVenta);
        entityManager.getTransaction().commit();
    }

    @Override
    public detalleVenta buscarPorId(int idDetalleVenta) {
        detalleVenta detalleVenta;
        detalleVenta = entityManager.find(detalleVenta.class, idDetalleVenta);
        return detalleVenta;
    }
}
