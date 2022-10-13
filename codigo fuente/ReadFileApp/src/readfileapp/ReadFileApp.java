
package readfileapp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Libro;
/**
 *
 * @author docente
 */
public class ReadFileApp {

    public static ArrayList cargarLibros(){
        ArrayList biblioteca=new ArrayList();
         try{
        
            
            File archivo = new File("C:\\Users\\Docente\\Documents\\Mis Proyectos\\Libros.txt");
            Scanner scanner = new Scanner(archivo);
            
            while(scanner.hasNextLine()){
                String linea=scanner.nextLine();
                
                System.out.println(linea);
                String[] datos = linea.split("#");
                
                String nombreLibro=datos[0];
                String editorial = datos[1];
                int anioPublicacion = Integer.parseInt(datos[2]);
                
                Libro libro = new Libro();
                libro.setNombre(nombreLibro);
                libro.setEditorial(editorial);
                libro.setAnioPublicacion(anioPublicacion);
                
                biblioteca.add(libro);
                
               
            }
        
        
        }catch(java.lang.NumberFormatException ex){
            System.out.println("Un numero no es valido");
            ex.printStackTrace();
        }catch(FileNotFoundException ex){
            System.out.println("Ocurrio un error al leer archivo");
            ex.printStackTrace();
        }
         return biblioteca;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList datos = cargarLibros();
        
        for(Object objeto : datos){
            Libro libro = (Libro)objeto;
            
            System.out.println("***********************************");
            System.out.println("Nombre del libro: "+libro.getNombre());
            System.out.println("Editorial: "+libro.getEditorial());
            System.out.println("***********************************");
        }
    }
    
}
