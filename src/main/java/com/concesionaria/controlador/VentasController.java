package com.concesionaria.controlador;

import com.concesionaria.dao.VentasImpl;
import com.concesionaria.idao.IVentasDao;
import com.concesionaria.modelo.autos;
import com.concesionaria.modelo.clientes;
import com.concesionaria.modelo.empleados;
import com.concesionaria.modelo.ventas;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named(value = "ventaBean")
public class VentaController {

    private IVentasDao ventasDao = new VentasImpl();
    private List<autos> autosList;
    private List<clientes> clientesList;
    private List<empleados> empleadosList;

    private ventas nuevaVenta;
    private List<ventas> ventasList;

    private List<autos> cars;
    private float total = 0;
    private float ice = 0;
    private float totalPagar = 0;

    public VentaController() {
        nuevaVenta = new ventas();
        cars = new ArrayList<>();
        autosList = obtenerAutos();
        clientesList = obtenerClientes();
        empleadosList = obtenerEmpleados();
        ventasList = obtenerVentas();
    }

    // Métodos para obtener listas
    public List<autos> obtenerAutos() {
        // Implementa la lógica para obtener la lista de autos desde el DAO correspondiente
        // Puedes utilizar el método autosDao.obtenerAutos()
        return new ArrayList<>();
    }

    public List<clientes> obtenerClientes() {
        // Implementa la lógica para obtener la lista de clientes desde el DAO correspondiente
        // Puedes utilizar el método clientesDao.obtenerClientes()
        return new ArrayList<>();
    }

    public List<empleados> obtenerEmpleados() {
        // Implementa la lógica para obtener la lista de empleados desde el DAO correspondiente
        // Puedes utilizar el método empleadosDao.obtenerEmpleados()
        return new ArrayList<>();
    }

    public List<ventas> obtenerVentas() {
        // Implementa la lógica para obtener la lista de ventas desde el DAO correspondiente
        // Puedes utilizar el método ventasDao.obtenerVentas()
        return new ArrayList<>();
    }

    // Métodos para el manejo de autos en la venta
    public void agregarAuto() {
        // Implementa la lógica para agregar un auto a la venta
        // Puedes utilizar el método autosDao.obtenerAutoPorId(autoId) para obtener el auto por ID
        // Añade el auto a la lista cars
        // Actualiza los valores (total, ice, totalPagar) llamando al método updateValues()
    }

    public void cambiarAuto(int indice) {
        // Implementa la lógica para cambiar un auto en la venta
        // Puedes utilizar el método autosDao.obtenerAutoPorId(autoId) para obtener el nuevo auto por ID
        // Actualiza los valores (total, ice, totalPagar) llamando al método updateValues()
    }

    public void cambiarCantidad(int indice) {
        // Implementa la lógica para cambiar la cantidad de un auto en la venta
        // Actualiza los valores (total, ice, totalPagar) llamando al método updateValues()
    }

    public void actualizarValores() {
        // Implementa la lógica para actualizar los valores (total, ice, totalPagar)
        // Itera sobre la lista de autos y calcula los valores totales
        // Llama al método updateValues() para actualizar los valores
    }

    // Método para guardar la venta
    public String guardarVenta() {
        try {
            // Validación de los campos (puedes agregar más reglas según tus necesidades)
            if (nuevaVenta.getCliente() == null || nuevaVenta.getEmpleado() == null || nuevaVenta.getFechaVenta() == null
                    || nuevaVenta.getMetodoPago() == null || totalPagar <= 0) {
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
            e.printStackTrace(); // Maneja la excepción según tus necesidades
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar la venta.", null));
            return null;
        }
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
}
