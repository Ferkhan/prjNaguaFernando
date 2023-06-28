import java.util.Scanner;

import FNUtility.FNUtileria;

public class App {

    protected static Scanner fnScanner = new Scanner(System.in);
    static String[] fnListaUsuarios = {"fernando.nagua@epn.edu.ec", "profe"};
    static String[] fnListaClaves = {"1724721301", "1234"};
    static String fnUsuarioAutenticado = "";
    
    public static void main(String[] args) throws Exception {
        int fnOpcMenu;
        FNUtileria.fnDatosPersonales();

        if (fnLogin()) {
            fnOpcMenu = fnMenu();

            switch (fnOpcMenu) {
                case 1:

                case 2:

                case 3:


                case 4:

                default: 
                    System.out.println("\nRegresa pronto " + fnUsuarioAutenticado);
            }
        } else {
            System.out.println("Gracias");
        }
        


    }

    /**
     * Solicita una autentificación con nombre de usuario y clave.
     * @return un booleano
     */
    private static boolean fnLogin() {

        int fnIntentosMax = 3;
        int fnIntentosRestantes = fnIntentosMax;
        boolean fnAcceso = false;

        do {
            FNUtileria.fnLimpiarConsola();

            System.out.println("......................");
            System.out.print("+ usuario:  ");
            String fnUsuario = fnScanner.nextLine();
            
            System.out.print("+ clave:    ");
            String fnClave = fnScanner.nextLine();
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
            System.out.println("\n:: Bienvenido " + fnUsuarioAutenticado);
            System.out.println("<< Presione ENTER para continuar >>");
            fnScanner.nextLine();
            FNUtileria.fnLimpiarConsola();
        }

        return fnAcceso;
    }

    private static int fnMenu() {
        int fnOpcMenu;
        System.out.println("------------------------");
        System.out.println("CARGA HORARIO DE MEDICOS");
        System.out.println("------------------------");
        System.out.println("Usuario: " + fnUsuarioAutenticado);
        System.out.println("1. Visualizar Medicos");
        System.out.println("2.Visualizar Especialidad");
        System.out.println("3. Visualizar Horario");
        System.out.println("4. Visualizar Horario de una asignatura");
        System.out.println("0. Salir");
        fnOpcMenu = FNUtileria.fnGetNumeroPositivo(">  ");

        return fnOpcMenu;
    }

}
