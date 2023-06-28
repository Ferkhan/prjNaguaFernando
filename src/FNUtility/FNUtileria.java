package FNUtility;

import java.io.File;
import java.util.Scanner;

public class FNUtileria {
    private static Scanner fnScanner = new Scanner(System.in);

    /**
     * Imprime en pantalla las credenciales del autor
     */
    public static void fnDatosPersonales() {
        System.out.println("CEDULA:  1724721301");
        System.out.println("CORREO:  FERNANDO.NAGUA@EPN.EDU.EC");
        System.out.println("NOMBRE:  fernando alexander nagua uyaguari");

    }

    /**
     * Limpia la consola
     * 
     * @return true
     */
    public final static boolean fnLimpiarConsola() {
        try {
            String operatingSystem = System.getProperty("os.name"); // Check the current operating system

            if (operatingSystem.contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    /**
     * Solicita y valida que se ingrese un número mayor o igual a cero y menor o
     * igual a 4.
     * 
     * @param fnMensaje mensaje a mostrar.
     * @return un número positivo
     */
    public static int fnGetNumeroPositivo(String fnMensaje) {
        int fnNumero = -1;

        System.out.print(fnMensaje);

        do {
            try {
                fnNumero = fnScanner.nextInt();
                fnScanner.nextLine();
            } catch (Exception e) {
                fnScanner.nextLine();
                if (fnNumero < 0 || fnNumero > 4)
                    System.out.println("<< Opción no contemplada. Intente de nuevo >>");
                    System.out.print(">  ");
            }
        } while (fnNumero < 0 || fnNumero > 4);

        return fnNumero;
    }

    public static String fnGetNombreArchivo(String fnRuta) {
        File fnArchivo = new File(fnRuta);
        String fnNombre = fnArchivo.getName();
        int fnIndiceExtension = fnNombre.lastIndexOf(".");


        if (fnIndiceExtension != -1) {
            fnNombre = fnNombre.substring(0, fnIndiceExtension);
        }

        return fnNombre;
    }

}
