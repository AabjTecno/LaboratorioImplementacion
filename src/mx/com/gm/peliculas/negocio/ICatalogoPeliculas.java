package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.excepciones.*;

public interface ICatalogoPeliculas {
    
    String NOMBRE_RECURSO = "pelicula.txt";
    void agregarPelicula(String nombrePelicula ) ;
    void listarPelicula ();
    void buscarPelicula ( String buscar  ); 
    void iniciarCatalogoPelicula();   
    
 
}
