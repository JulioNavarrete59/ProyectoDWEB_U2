package com.concesionaria.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ventas")
public class ventas {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    @Column
    private String fechaVenta;
    @Column
    private float subtotal = 0;
    @Column
    private float ice = 0;
    @Column
    private float total = 0;
    @Column
    private String metodoPago;

    @ManyToOne
    private empleados empleado;

    /*@OneToMany
    private List<detalleVenta> detalleVenta;*/

    @ManyToOne
    private clientes cliente;

    public ventas() {
    }


    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIce() {
        return ice;
    }

    public void setIce(float ice) {
        this.ice = ice;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public clientes getCliente() {
        return cliente;
    }

    public void setCliente(clientes cliente) {
        this.cliente = cliente;
    }

    public empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(empleados empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "ventas{" +
                "idVenta=" + idVenta +
                ", fechaVenta='" + fechaVenta + '\'' +
                ", subtotal=" + subtotal +
                ", ice=" + ice +
                ", total=" + total +
                ", metodoPago='" + metodoPago + '\'' +
                '}';
    }
}
