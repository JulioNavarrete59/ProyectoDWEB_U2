package com.concesionaria.controlador;

import com.concesionaria.dao.AutosImpl;
import com.concesionaria.dao.VentasImpl;
import com.concesionaria.idao.IAutosDao;
import com.concesionaria.idao.IVentasDao;
import com.concesionaria.modelo.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named(value = "ventasBean")
public class VentasController {

    private IVentasDao ventasDao = new VentasImpl();
    private IAutosDao autosDao = new AutosImpl();
    private List<autos> autosList;
    private List<clientes> clientesList;
    private List<empleados> empleadosList;

    private List<detalleVenta> detalles;

    private ventas nuevaVenta;
    private List<ventas> ventasList;

    private List<autos> cars;
    private float total = 0;
    private float ice = 0;
    private float totalPagar = 0;

    private empleados empleado;
    private clientes cliente;
    private autos auto;
    private ventas venta;

    private detalleVenta detalle;

    public VentasController() {
        nuevaVenta = new ventas();
        cars = new ArrayList<>();
        autosList = obtenerAutos();
        clientesList = obtenerClientes();
        empleadosList = obtenerEmpleados();
        ventasList = obtenerVentas();
    }

    // Métodos para obtener listas
    public List<autos> obtenerAutos() {
        return ventasDao.obtenerAutos();
    }

    public List<clientes> obtenerClientes() {
        return ventasDao.obtenerClientes();
    }

    public List<empleados> obtenerEmpleados() {
        return ventasDao.obtenerEmpleados();
    }

    public List<ventas> obtenerVentas() {
        return ventasDao.obtenerVentas();
    }


    // Getters y setters

    public List<autos> getAutosList() {
        return autosList;
    }

    public List<clientes> getClientesList() {
        return clientesList;
    }

    public List<empleados> getEmpleadosList() {
        return empleadosList;
    }

    public ventas getNuevaVenta() {
        return nuevaVenta;
    }

    public void setNuevaVenta(ventas nuevaVenta) {
        this.nuevaVenta = nuevaVenta;
    }

    public List<ventas> getVentasList() {
        return ventasList;
    }

    public List<autos> getCars() {
        return cars;
    }

    public void setCars(List<autos> cars) {
        this.cars = cars;
    }

    public float getTotal() {
        return total;
    }

    public float getIce() {
        return ice;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(empleados empleado) {
        this.empleado = empleado;
    }

    public clientes getCliente() {
        return cliente;
    }

    public void setCliente(clientes cliente) {
        this.cliente = cliente;
    }

    public autos getAuto() {
        return auto;
    }

    public void setAuto(autos auto) {
        this.auto = auto;
    }

    public ventas getVenta() {
        return venta;
    }

    public void setVenta(ventas venta) {
        this.venta = venta;
    }

    public detalleVenta getDetalle() {
        return detalle;
    }

    public void setDetalle(detalleVenta detalle) {
        this.detalle = detalle;
    }

    public void addCar() {
        // Crear un nuevo detalle de venta
        detalleVenta detalle = new detalleVenta();
        ventas venta = new ventas();

        // Establecer las propiedades del detalle
        detalle.setAuto(this.auto);
        detalle.setCantidad(this.detalle.getCantidad());
        detalle.setPrecioVenta(this.detalle.getPrecioVenta());

        // Calcular el subtotal
        float subtotal = (float) (this.detalle.getCantidad() * this.detalle.getPrecioVenta());
        venta.setSubtotal(subtotal);

        // Agregar el detalle a la lista de detalles
        this.cars.add(detalle.getAuto());

        // Actualizar el total de la venta
        this.venta.setSubtotal(this.venta.getSubtotal() + subtotal);
    }

}
