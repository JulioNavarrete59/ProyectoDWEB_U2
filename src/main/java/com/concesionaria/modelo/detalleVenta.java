package com.concesionaria.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "detalleVenta")
public class detalleVenta {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleVenta;
    @Column
    private double cantidad;
    @Column
    private double precioVenta;
    @Column
    private String detalle;
    @ManyToOne
    private autos auto;
    @ManyToOne
    private ventas venta;

    public detalleVenta() {
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
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

    @Override
    public String toString() {
        return "detalleVenta{" +
                "idDetalleVenta=" + idDetalleVenta +
                ", cantidad=" + cantidad +
                ", precioVenta=" + precioVenta +
                ", detalle='" + detalle + '\'' +
                '}';
    }
}
