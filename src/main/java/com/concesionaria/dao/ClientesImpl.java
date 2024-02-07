package com.concesionaria.dao;

import com.concesionaria.idao.IClientesDao;
import com.concesionaria.modelo.JPAUtil;
import com.concesionaria.modelo.clientes;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ClientesImpl implements IClientesDao {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void registrar(clientes clientes) {
        entityManager.getTransaction().begin();
        entityManager.persist(clientes);
        entityManager.getTransaction().commit();
    }

    @Override
    public void modificar(clientes clientes) {
        entityManager.getTransaction().begin();
        entityManager.merge(clientes);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        clientes  cliente;
        cliente = entityManager.find(clientes.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<clientes> obtenerClientes() {
        List<clientes> listaClientes;
        listaClientes = entityManager.createQuery("SELECT a FROM clientes a").getResultList();
        return listaClientes;
    }

    @Override
    public clientes obtenerClientesPorId(int id) {
        clientes cliente;
        cliente = entityManager.find(clientes.class, id);
        return cliente;
    }
}
