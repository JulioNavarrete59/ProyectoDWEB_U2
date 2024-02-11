package com.concesionaria.controlador;

import com.concesionaria.dao.AutosImpl;
import com.concesionaria.dao.VentasImpl;
import com.concesionaria.idao.IAutosDao;
import com.concesionaria.idao.IVentasDao;
import com.concesionaria.modelo.autos;
import com.concesionaria.modelo.clientes;
import com.concesionaria.modelo.detalleVenta;
import com.concesionaria.modelo.ventas;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named(value = "ventaBean")
public class VentasController {

    /*private IVentasDao ventasDao = new VentasImpl();
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
    // Métodos para el manejo de autos en la venta
    public void agregarAuto(int autoId) {
        autos auto = autosDao.obtenerAutosPorId(autoId);
        cars.add(auto);
        updateValues();
    }

    public void cambiarAuto(int indice, int autoId) {
        autos auto = autosDao.obtenerAutosPorId(autoId);
        cars.set(indice, auto);
        updateValues();
    }

    // Método para actualizar los valores de la venta
    private void updateValues() {
        actualizarValores();
    }

    public void cambiarCantidad(int indice, int cantidad) {
        autos auto = cars.get(indice);
        auto.setCantidad(cantidad);
        updateValues();
    }
    public void actualizarValores() {
        this.subtotal = 0;
        this.ice = 0;
        for (detalleVenta detalle : detalles) {
            this.subtotal += detalle.calcularSubtotal();
            this.ice += detalle.calcularIce();
        }
        this.total = this.subtotal + this.ice;
    }

    // Método para guardar la venta
    public String guardarVenta() {
        try {
            if (!validarVenta()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de validación", "Todos los campos deben estar llenos y el total a pagar debe ser mayor que 0."));
                return null;
            }

            // Configura la lista de autos en la venta antes de guardar
            nuevaVenta.setAutosList(cars);

            // Guarda la venta
            ventasDao.registrar(nuevaVenta);

            // Puedes agregar un mensaje de éxito o redirección si lo deseas
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Venta registrada con éxito.", null));

            // Reinicia las variables para una nueva venta
            nuevaVenta = new ventas();
            cars = new ArrayList<>();
            total = 0;
            ice = 0;
            totalPagar = 0;

            // Actualiza la lista de ventas
            ventasList = obtenerVentas();

            return "indexVentas?faces-redirect=true"; // Puedes redirigir a la página que desees
        } catch (Exception e) {
            // Maneja la excepción según tus necesidades
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar la venta.", null));
            return null;
        }
    }
    private boolean validarVenta() {
        return nuevaVenta.getCliente() != null && nuevaVenta.getEmpleado() != null && nuevaVenta.getFechaVenta() != null
                && nuevaVenta.getMetodoPago() != null && totalPagar > 0;
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
    }*/
}
