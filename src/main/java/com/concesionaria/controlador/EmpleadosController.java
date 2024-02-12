package com.concesionaria.controlador;


import com.concesionaria.dao.EmpleadosImpl;
import com.concesionaria.idao.IEmpleadosDao;
import com.concesionaria.modelo.empleados;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.util.List;
import java.util.Map;

@RequestScoped
@Named(value = "empleadosBean")
public class EmpleadosController {

    IEmpleadosDao empleadosDao = new EmpleadosImpl();
    private empleados empleado = new empleados();
    public List<empleados> obtenerEmpleado() {
        return empleadosDao.obtenerEmpleados();
    }
    public String editar(int id) {
        empleados oEmpleados = new empleados();
        oEmpleados = empleadosDao.obtenerEmpleadosPorId(id);
        System.out.println(oEmpleados);
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("empleado", oEmpleados);
        return "/editar.xhtml";
    }
    public String actualizar(empleados empleado) {
        empleadosDao.modificar(empleado);
        return "/index.xhtml";
    }
    public void eliminar(int id) {
        empleadosDao.eliminar(id);
        System.out.println("Empleado eliminado");
    }
    public String registrar(empleados empleado) {
        empleadosDao.registrar(empleado);
        return "/empleados/index.xhtml";
    }

    public String registrarEmpleado() {
        empleadosDao.registrar(empleado);
        return "/empleados/index.xhtml";
    }
    public empleados getEmpleado() {
        return empleado;
    }
    public void setEmpleado(empleados empleado) {
        this.empleado = empleado;
    }

}
