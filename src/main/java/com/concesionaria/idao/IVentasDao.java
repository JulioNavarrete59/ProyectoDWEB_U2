package com.concesionaria.idao;

import com.concesionaria.modelo.ventas;

import java.util.List;

public interface IVentasDao {
    void registrar(ventas ventas);
    void modificar(ventas ventas);
    void eliminar(int id);
    List<ventas> obtenerVentas();
    ventas obtenerVentasPorId(int id);
}
