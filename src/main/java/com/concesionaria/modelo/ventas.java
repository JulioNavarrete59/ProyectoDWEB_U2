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
    private int cliente_id;
    @Column
    private int empleado_id;
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
    @JoinColumn(name = "cliente_id", referencedColumnName = "idCliente", insertable = false, updatable = false)
    private clientes cliente;

    @ManyToOne
    @JoinColumn(name = "auto_id", referencedColumnName = "idAuto", insertable = false, updatable = false)
    private autos auto;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<autos> autosList;

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

    public List<autos> getAutosList() {
        return autosList;
    }

    public void setAutosList(List<autos> autosList) {
        this.autosList = autosList;
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
