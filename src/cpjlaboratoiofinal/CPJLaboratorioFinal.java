package cpjlaboratoiofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

public class CPJLaboratorioFinal {

    public static void main(String[] args) {

        var opcion = -1 ;  
        var scanner = new Scanner (System.in);  
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl(); 
        
        while (opcion !=0){
            
            System.out.println("ELIGE UNA OPCION \n"
            +"1. Iniciar Catalogo Pelicula \n"
            +"2. Agregar Pelicula \n"
            +"3. Listar Peliculas \n"
            +"4. Buscar Pelicula \n"
            +"0. Salir "
            +"\n"
            +"Opcion : " );
           opcion =Integer.parseInt(scanner.nextLine()); 
           
           
           switch (opcion){
               
               case 1:  
                   catalogo.iniciarCatalogoPelicula(); 
                   break;  
               case 2: 
                   System.out.println("AGREGAR PELICULA");
                   System.out.println("");
                   System.out.println("Ingrese el nombre de la pelicula :");
                   var nombrepeli = scanner.nextLine(); 
                   catalogo.agregarPelicula(nombrepeli);  
                   break; 
               case 3:  
                   System.out.println("LISTAR PELICULA");
                   System.out.println("");
                   catalogo.listarPelicula();
                   break;  
               case 4:  
                   System.out.println("BUSCAR PELICULA");
                   System.out.println("");
                   System.out.println("Introduce el nombre de la pelicula : "); 
                   var buscar = scanner.nextLine();
                   catalogo.buscarPelicula(buscar);
                   break;  
               case 0:  
                   System.out.println("Programa Finalizado...");
                   break;  
               default : 
                   System.out.println("Opcion no valido");
                
           }
            
        }
        

        
    }
    
}
