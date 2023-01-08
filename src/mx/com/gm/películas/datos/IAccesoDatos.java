package mx.com.gm.películas.datos;

import java.util.*;
import mx.com.gm.peliculas.excepciones.* ;
import mx.com.gm.películas.domain.Pelicula;

public interface IAccesoDatos {
    // Primero 
    
    boolean existe(String nombreArchivo)throws AccesoDatosEx; 
    
    List<Pelicula> listar (String nombre) throws LecturaDatosEx; 
    void escribir(Pelicula pelicula ,String nombreArchivo , boolean anexar)throws EscrituraDatosEx; 
    String buscar(String nombreArchivo ,String buscar) throws LecturaDatosEx; 
    void crearArchivo (String nombreArchivo)throws AccesoDatosEx; 
    void borrar(String nombreArchivo)throws AccesoDatosEx;   
    
    
    
}
