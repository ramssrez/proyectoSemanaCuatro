import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Prueba {
    public static void main(String[] args) {
        File nuevaCarpeta = new File("./Calculos");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        String pathCarpet = "./Calculos/" + localDate.toString();
        File carpetaNueva  = new File(pathCarpet);
        String nombreArchivo = "Hola.txt";

        if (!carpetaNueva.exists()){
            boolean carpetaCreada = carpetaNueva.mkdir();
            System.out.println("carpetaCreada = " + carpetaCreada);
            File crearArchivo = new File(carpetaNueva,nombreArchivo);
            try {
                crearArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (!nuevaCarpeta.exists()) {
            boolean carpetaCreada = nuevaCarpeta.mkdir();
            System.out.println("carpetaCreada = " + carpetaCreada);

            File crearArchivo = new File(nuevaCarpeta,"Hola Mundo.txt");
            try {
                crearArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Archivo creado = " + crearArchivo);
        }

        File directorio = new File("./");

        String[] archivos = directorio.list();

        for(String archivo : archivos) {
            System.out.println("archivo = " + archivo);
        }
    }
}
