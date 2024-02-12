package com.concesionaria.idao;

import com.concesionaria.modelo.empleados;
import java.util.List;

public interface IEmpleadosDao {

    void registrar(empleados empleados);
    void modificar(empleados empleados);
    empleados obtenerEmpleadosPorId(int id);
    List<empleados> obtenerEmpleados();
    void eliminar(int id);
}
