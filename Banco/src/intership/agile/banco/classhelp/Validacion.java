package intership.agile.banco.classhelp;

public class Validacion {
    public Validacion() {
    }
    public static double validarDouble(String argumento){
        double valor  = 0.0;
        boolean bandera = false;
        while (!bandera){
            try {
                System.out.print(argumento);
                valor = Double.parseDouble(System.console().readLine());
                bandera = true;
            }catch (Exception e){
                System.out.println("Valor incorrecto, se espera un double");
            }
        }
        return valor;
    }
    public static int validarEntero(String argumento){
        int valor  = 0;
        boolean bandera = false;
        while (!bandera){
            try {
                System.out.print(argumento);
                valor = Integer.parseInt(System.console().readLine());
                bandera = true;
            }catch (Exception e){
                System.out.println("Valor incorrecto, se espera un entero");
            }
        }
        return valor;
    }
    public static String validarString(String argumento){
        boolean bandera = false;
        String string = "";
        while (!bandera){
            try {
                System.out.print(argumento);
                string = System.console().readLine();
                if (!soloLetras(string) || string.isEmpty()){
                    System.err.println("Nombre incorrecto, intenta de nuevo");
                }else {
                    bandera = true;
                }
            }catch (Exception e){
                System.out.println("Valor incorrecto, se espera un string");
            }
        }
        return string;
    }
    private static boolean soloLetras(String cadena) {
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }
}
