package com.concesionaria.modelo;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    //Metodo para crear una sola instancia de la fabrica de entidades
    //Nombre de la unidad de persistencia
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE_UNIT";
    //Atributo de tipo EntityManagerFactory
    private static EntityManagerFactory factory;
    //Metodo para obtener la fabrica de entidades
    public static EntityManagerFactory getEntityManagerFactory(){
        //Verificamos si la fabrica de entidades es igual a null
        if (factory == null){
            //Creamos la fabrica de entidades
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        //Retornamos la fabrica de entidades
        return factory;
    }
    //Metodo para cerrar la fabrica de entidades
    public static void shutdown(){
        //Verificamos si la fabrica de entidades es diferente de null
        if (factory != null) {
            //Cerramos la fabrica de entidades
            factory.close();
        }
    }
}
