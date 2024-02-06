package com.concesionaria.idao;

import com.concesionaria.modelo.clientes;

import java.util.List;

public interface IClientesDao {
    void registrar(clientes clientes);
    void modificar(clientes clientes);
    void eliminar(int id);
    List<clientes> obtenerClientes();
    clientes obtenerClientesPorId(int id);
}
