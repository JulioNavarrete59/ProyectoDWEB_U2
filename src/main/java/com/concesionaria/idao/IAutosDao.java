package com.concesionaria.idao;

import com.concesionaria.modelo.autos;

import java.util.List;

public interface IAutosDao {
    void registrar(autos autos);
    void modificar(autos autos);
    void eliminar(int id);
    List<autos> obtenerAutos();
    autos obtenerAutosPorId(int id);
}
