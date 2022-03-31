import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {
        File nuevaCarpeta = new File("./Calculos");

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
