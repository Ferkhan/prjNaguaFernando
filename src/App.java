import java.util.Scanner;

public class App {
    protected static Scanner fnScanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        if (fnLogin()) {
            System.out.println("todo bien");
        } else {
            System.out.println("Gracias");
        }
        


    }

    private static boolean fnLogin() {
        String[] fnListaUsuarios = {"fernando.nagua@epn.edu.ec", "profe"};
        String[] fnListaClaves = {"1724721301", "1234"};

        int fnIntentosMax = 3;
        int fnIntentosRestantes = fnIntentosMax;
        boolean fnAcceso = false;
        String fnUsuarioAutenticado = "";

        do {
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

                if (fnIntentosRestantes == 0) {
                    System.out.println("¡Lo sentimos, tu usuario y clave son incorrectos...!");
                    break;
                }
            }

        } while (!fnAcceso);
        
        if (fnAcceso) {
            System.out.println(":: Bienvenido " + fnUsuarioAutenticado);
        }

        return fnAcceso;
        // fnScanner.close();
    }
}
