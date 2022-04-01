import constants.Messages;
import constants.ValidateInputs;
import exepctions.ExeptionAplication;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Prueba {
    public static void main(String[] args) {
        crearCarpetaGeneral();
        LocalDate localDate = LocalDate.now();
        StringBuilder builder = new StringBuilder(Messages.PATH);
        builder.append(localDate.toString());
        //String pathCarpet = Messages.PATH + localDate.toString();

        File fechaCarpeta  = new File(builder.toString());
        if (fechaCarpeta.mkdir()) System.out.println("Carpeta " + localDate.toString() + " creada");

        ValidateInputs validateInputs = new ValidateInputs();

        boolean bandera = false;
        while (!bandera) {
            String nombre = null;
            try {
                nombre = validateInputs.inputString("Ingresa el nombre del archivo: ");
                if (!fechaCarpeta.exists()){
                    bandera = crearArchivo(nombre,fechaCarpeta);
                }else if (fechaCarpeta.exists()){
                    bandera = crearArchivo(nombre,fechaCarpeta);
                }
            } catch (ExeptionAplication e) {
                System.err.println(e.getMessage());
                //e.printStackTrace();
            }

        }

    }

    public static void crearCarpetaGeneral() {
        File carpetaNueva = new File(Messages.PATH);
        System.out.println(carpetaNueva.toString());
        boolean mkdir = carpetaNueva.mkdir();
    }
    public static boolean crearArchivo(String nombre,File path){
        boolean bandera = false;
        try {
            nombre = nombre + Messages.TYPE;
            File crearArchivo = new File(path,nombre);
            if (crearArchivo.exists()){
                System.out.println("Este nombre ya existe, vuelve ingresar el nombre");
            }else {
                if(crearArchivo.createNewFile()){
                    System.out.println("El archivo a sido creado en: " + crearArchivo.toString());
                    bandera = true;
                }else{
                    System.out.println("Ocurrio un problema, no se ha creado el archivo, vuelve a ingresar el nombre");
                }
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
            //bandera = false;
        }
        return bandera;
    }
}
