package com.concesionaria.idao;

import com.concesionaria.modelo.detalleVenta;

import java.util.List;

public interface IDetalleVentaDao {
    void guardarDetalleVenta(detalleVenta detalleVenta);
    List<detalleVenta> obtenerDetallesVenta();
    void eliminarDetalleVenta(int idDetalleVenta);
    void actualizarDetalleVenta(detalleVenta detalleVenta);
    detalleVenta buscarPorId(int idDetalleVenta);
}
