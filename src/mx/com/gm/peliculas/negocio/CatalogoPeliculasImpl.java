package mx.com.gm.peliculas.negocio;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.gm.películas.datos.*;
import mx.com.gm.películas.domain.Pelicula;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
        // Asi Podriamos Acceder a los Metodos de otra Interface  

    }

    @Override
    public void agregarPelicula(String nombrePelicula)  {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);

        } catch (AccesoDatosEx ex) {
            System.out.println("Error Acceso Datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPelicula() {
        
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO); 
            
            for (var pelicula:peliculas){
                System.out.println(pelicula );
            }
            
            
        } catch (LecturaDatosEx ex) { 
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar)  {

        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
            System.out.println("resultado = " + resultado);

        } catch (AccesoDatosEx ex) {
            System.out.println("Error Acceso Datos ");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogoPelicula() {

        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                this.datos.borrar(NOMBRE_RECURSO);
                this.datos.crearArchivo(NOMBRE_RECURSO);

            } else {
                this.datos.crearArchivo(NOMBRE_RECURSO);
            }

        } catch (AccesoDatosEx ex) { 
            System.out.println("Error al Iniciar Catalogo Peliculas");
            ex.printStackTrace(System.out);

        }

    }

}
