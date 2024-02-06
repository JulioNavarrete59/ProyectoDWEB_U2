package com.concesionaria.modelo;

import jakarta.persistence.*;

//Anotaciones
@Entity
//Nombre de la tabla
@Table(name = "auto")
public class autos {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuto;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String anio;
    @Column
    private String precio;
    @Column
    private String foto;

    //Constructor
    public autos() {
    }

    public int getIdAuto() {
        return idAuto;
    }
    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    @Override
    public String toString() {
        return "autos{" +
                "idAuto=" + idAuto +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio='" + anio + '\'' +
                ", precio='" + precio + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
