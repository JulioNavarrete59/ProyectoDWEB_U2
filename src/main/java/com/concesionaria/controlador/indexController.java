package com.concesionaria.controlador;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named(value = "indexController")
public class indexController {

    public String autos() {
        return "/autos/index.xhtml";
    }

    public String clientes() {
        return "/clientes/index.xhtml";
    }
    public String empleados() {
        return "/empleados/index.xhtml";
    }
    public String ventas() {
        return "/ventas/index.xhtml";
    }
}
