package com.concesionaria.controlador;

import com.concesionaria.dao.AutosImpl;
import com.concesionaria.idao.IAutosDao;
import com.concesionaria.modelo.autos;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jdk.jfr.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//Anotación para el controlador}
@RequestScoped
//Nombre del bean
@Name(value = "autosBean")
public class AutosController {
    IAutosDao autosDao = new AutosImpl();
    public List<autos> obtenerAutos(){
        return autosDao.obtenerAutos();
    }
    public String editar (int id){
        autos oAutos = new autos();
        oAutos = autosDao.obtenerAutosPorId(id);
        System.out.println(oAutos);
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //Añadir el objeto usuario a la colección
        sessionMap.put("auto", oAutos);
        return "/editarAutos.xhtml";
    }
    public String actualizar(autos autos){
        autosDao.modificar(autos);
        return "/indexAutos.xhtml";
    }
    public void eliminar (int id){
        autosDao.eliminar(id);
    }
    public String registrar(autos autos){
        autosDao.registrar(autos);
        return "/indexAutos.xhtml";
    }
    public String nuevo(){
        autos oAutos = new autos();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //Añadir el objeto usuario a la colección
        sessionMap.put("auto", oAutos);
        return "/crearAutos.xhtml";
    }
}
