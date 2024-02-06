package com.concesionaria.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "ventas")
public class ventas {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    @Column
    private int cliente_id;
    @Column
    private int empleado_id;
    @Column
    private String fechaVenta;
    @Column
    private float subtotal;
    @Column
    private float ice;
    @Column
    private float total;
    @Column
    private String metodoPago;

    public ventas() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
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

    @Override
    public String toString() {
        return "ventas{" +
                "idVenta=" + idVenta +
                ", cliente_id=" + cliente_id +
                ", empleado_id=" + empleado_id +
                ", fechaVenta='" + fechaVenta + '\'' +
                ", subtotal=" + subtotal +
                ", ice=" + ice +
                ", total=" + total +
                ", metodoPago='" + metodoPago + '\'' +
                '}';
    }
}
