package mx.com.gm.películas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.gm.películas.domain.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File(nombreArchivo);
        return archivo.exists(); // para indicar que si existe 
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {

        var archivo = new File(nombre);
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            // Leer cada linea que pongamos
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = leer.readLine();// linea es igual al contenido de la linea   

            while (linea != null) { // Mientras en el archivo haya contenido 
                var pelicula = new Pelicula(linea);  // se va crear un ArrayList tipo pelicula
                peliculas.add(pelicula);  // se va agregar la pelicula
                leer.readLine(); // siguiente linea 
            }
            
            leer.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion Listar Pelicula: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion Listar Pelicula: " + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        
            var archivo = new File(nombreArchivo);
            try {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));  // Para anexar
                salida.println(pelicula.toString());
                salida.close(); 
                System.out.println("Se ha Escrito en el Archivo");
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new EscrituraDatosEx("Excepcion al Escribir Pelicula " + ex.getMessage());
            }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx { 
        var archivo = new File (nombreArchivo);   
        String resultado = null;  
        
        try { 
            var entrada = new BufferedReader(new FileReader(archivo)); 
            String linea = entrada.readLine(); 
            int indice =1 ; 
            while (linea!=null){
                
                if (buscar!=null & buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula Encontrada :"+linea +" En el Indice "+indice ;  
                    break; 
                } 
                linea= entrada.readLine();// leemos las siguiente linea 
                indice++;    
                
            }
            entrada.close();
        } catch (FileNotFoundException ex) { 
            throw new LecturaDatosEx("Excepcion LecturaDatosEx"+ex.getMessage());
        } catch (IOException ex) { 
            throw new LecturaDatosEx("Excepcion al Buscar la Pelicula"+ex.getMessage());
        }
        
        
        return resultado; 
        
    }

    @Override
    public void crearArchivo(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha Creado Correctamente");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo) { 
        var archivo = new File (nombreArchivo); 
        if (archivo.exists()){
            archivo.delete(); 
            System.out.println("Se ha Borrado Correctamente");
        }
        else {
            System.out.println("El Archivo No Existe");
        }
    }

}
