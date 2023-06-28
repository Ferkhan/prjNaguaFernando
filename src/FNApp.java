import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

import BL.FNHorario;
import FNUtility.FNUtileria;

public class FNApp {

    protected static Scanner fnScanner = new Scanner(System.in);
    static String[] fnListaUsuarios = {"fernando.nagua@epn.edu.ec", "profe"};
    static String[] fnListaClaves = {"1724721301", "1234"};
    static String fnUsuarioAutenticado = "";
    private String fnHorarioRutaDirectorio;

    public static void main(String[] args) throws Exception {
        int fnOpcMenu = 1;
        FNHorario fnH = new FNHorario();

        if (fnLogin()) {
            while (fnOpcMenu != 0) {
                fnOpcMenu = fnMenu();

                switch (fnOpcMenu) {
                    case 1:
                        fnH.fnShowMedicos();
                        break;
                    case 2:
                        fnH.fnReadHorarioMedicos("src\\BL\\Horarios\\202110105-CHUNCHO JIMENEZ ANGEL DAVID.csv");
                        break;
                    case 3:
                        System.out.println("Horario en proceso...");
                        break;
                    case 4:
                        System.out.println("Horario en proceso...");
                        break;
                }
                if (fnOpcMenu > 0 && fnOpcMenu <= 4) {
                    System.out.println("\n<< Presione ENTER para volver al menú principal >>");
                    fnScanner.nextLine();
                    FNUtileria.fnLimpiarConsola();
                }

            }
        } else {
            System.out.println("Gracias");
        }
        System.out.println(FNUtileria.purple + "\nRegresa pronto " + fnUsuarioAutenticado + FNUtileria.reset);
    }

    /**
     * Solicita una autentificación con nombre de usuario y clave.
     * @return un booleano
     */
    private static boolean fnLogin() {
        
        int fnIntentosMax = 3;
        int fnIntentosRestantes = fnIntentosMax;
        boolean fnAcceso = false;
        Console fnConsole = System.console();

        do {
            FNUtileria.fnLimpiarConsola();
        FNUtileria.fnDatosPersonales();
            System.out.println("......................");
            System.out.print(FNUtileria.green + "+ usuario:  " + FNUtileria.reset);
            String fnUsuario = fnScanner.nextLine();
            
            // System.out.print(FNUtileria.green + "+ clave:    " + FNUtileria.reset);
            char[] fnClaveArray = fnConsole.readPassword(FNUtileria.green + "+ clave:    " + FNUtileria.reset);
            String fnClave = new String(fnClaveArray);
            // String fnClave = fnScanner.nextLine();
            Arrays.fill(fnClaveArray, ' ');
            System.out.println("......................");


            for (int i = 0; i < fnListaUsuarios.length; i++) {
                if (fnUsuario.equals(fnListaUsuarios[i]) && fnClave.equals(fnListaClaves[i])) {
                    fnAcceso = true;
                    fnUsuarioAutenticado = fnUsuario.toUpperCase();
                    break;
                }
            }

            if (!fnAcceso) {
                fnIntentosRestantes--;
                System.out.println("* Nro de intentos: " + fnIntentosRestantes);
                System.out.println("<< Incorrecto. Presione enter para intentar de nuevo >>");
                fnScanner.nextLine();

                if (fnIntentosRestantes == 0) {
                    System.out.println("¡Lo sentimos, tu usuario y clave son incorrectos...!");
                    break;
                }
            }

        } while (!fnAcceso);
        
        if (fnAcceso) {
            System.out.println("\n:: Bienvenido " + FNUtileria.cyan + fnUsuarioAutenticado + FNUtileria.reset);
            System.out.println("<< Presione ENTER para continuar >>");
            fnScanner.nextLine();
            FNUtileria.fnLimpiarConsola();
        }

        return fnAcceso;
    }

    /**
     * Menú principal
     * @return variable int
     */
    private static int fnMenu() {
        int fnOpcMenu;
        System.out.println(FNUtileria.green + "------------------------");
        System.out.println("CARGA HORARIO DE MEDICOS");
        System.out.println("------------------------" + FNUtileria.reset);
        System.out.println("Usuario: " + FNUtileria.cyan + fnUsuarioAutenticado + FNUtileria.reset);
        System.out.println("1. Visualizar Medicos");
        System.out.println("2. Visualizar Especialidad");
        System.out.println("3. Visualizar Horario");
        System.out.println("4. Visualizar Horario de una asignatura");
        System.out.println("0. Salir");
        fnOpcMenu = FNUtileria.fnGetNumeroPositivo(">  ");

        return fnOpcMenu;
    }

}
