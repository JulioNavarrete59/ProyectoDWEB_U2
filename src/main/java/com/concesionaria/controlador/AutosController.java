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
@RequestScoped
//Nombre del bean
@Named(value = "autosBean")
public class AutosController {
    IAutosDao autosDao = new AutosImpl();
    autos auto = new autos();
    public List<autos> obtenerAuto(){
        return autosDao.obtenerAutos();
    }
    public String editar (int id){
        autos oAutos = new autos();
        oAutos = autosDao.obtenerAutosPorId(id);
        System.out.println(oAutos);
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //Añadir el objeto usuario a la colección
        sessionMap.put("auto", oAutos);
        return "/autos/editar.xhtml";
    }
    public String actualizar(autos auto){
        autosDao.modificar(auto);
        return "/autos/index.xhtml";
    }
    public void eliminar (int id){
        autosDao.eliminar(id);
    }
    public String registrar(){
        autosDao.registrar(auto);
        return "/autos/index.xhtml";
    }
    public String nuevo(){
        autos oAuto = new autos();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //Añadir el objeto usuario a la colección
        sessionMap.put("auto", oAuto);
        return "/autos/crear.xhtml";
    }

    public autos getAuto() {
        return auto;
    }
    public void setAuto(autos auto) {
        this.auto = auto;
    }


}
