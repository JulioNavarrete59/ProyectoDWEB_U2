package com.concesionaria.controlador;

import com.concesionaria.dao.AutosImpl;
import com.concesionaria.dao.ClientesImpl;
import com.concesionaria.idao.IAutosDao;
import com.concesionaria.idao.IClientesDao;
import com.concesionaria.modelo.autos;
import com.concesionaria.modelo.clientes;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
import java.util.Map;

//Anotación para el controlador}
@RequestScoped
//Nombre del bean
@Named(value = "clientesBean")
public class ClientesController {
    IClientesDao clientesDao = new ClientesImpl();
    private clientes cliente = new clientes();
    public List<clientes> obtenerCliente(){
        return clientesDao.obtenerClientes();
    }
    public String editar (int id){
        clientes oClientes = new clientes();
        oClientes = clientesDao.obtenerClientesPorId(id);
        System.out.println(oClientes);
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //Añadir el objeto usuario a la colección
        sessionMap.put("cliente", oClientes);
        return "/editar.xhtml";
    }
    public String actualizar(clientes cliente){
        clientesDao.modificar(cliente);
        return "/index.xhtml";
    }
    public void eliminar (int id){
        clientesDao.eliminar(id);
    }
    public String registrar(clientes clientes){
        clientesDao.registrar(clientes);
        return "/index.xhtml";
    }
    /*public String nuevo(){
        clientes oCliente = new clientes();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //Añadir el objeto usuario a la colección
        sessionMap.put("cliente", oCliente);
        return "/clientes/crear.xhtml";
    }*/

    public String registrarCliente( ){
        clientesDao.registrar(cliente);
        return "/clientes/index.xhtml";
    }

    public clientes getCliente() {
        return cliente;
    }

    public void setCliente(clientes cliente) {
        this.cliente = cliente;
    }
}
