package com.concesionaria.dao;

import com.concesionaria.idao.IEmpleadosDao;
import com.concesionaria.modelo.JPAUtil;
import com.concesionaria.modelo.empleados;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EmpleadosImpl implements IEmpleadosDao {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void registrar(empleados empleados) {
        entityManager.getTransaction().begin();
        entityManager.persist(empleados);
        entityManager.getTransaction().commit();
    }

    @Override
    public void modificar(empleados empleados) {
        entityManager.getTransaction().begin();
        entityManager.merge(empleados);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        empleados  empleado;
        empleado = entityManager.find(empleados.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(empleado);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<empleados> obtenerEmpleados() {
        List<empleados> listaEmpleados;
        listaEmpleados = entityManager.createQuery("SELECT a FROM empleados a").getResultList();
        return listaEmpleados;
    }

    @Override
    public empleados obtenerEmpleadosPorId(int id) {
        empleados empleado;
        empleado = entityManager.find(empleados.class, id);
        return empleado;
    }

}
