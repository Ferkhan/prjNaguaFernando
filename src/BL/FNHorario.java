package BL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class FNHorario extends FNHorarioBase implements FNGestiaArchivoHorario {


    public void fnShowHorario() {

    }

    @Override
    public void fnReadHorarioMedicos(String fnDirectorioHorarios) {        
        File fnCarpeta = new File("src\\BL\\Horarios");
        System.out.println(fnCarpeta.exists());
        if (fnCarpeta.isDirectory()) {
            File[] fnArchivos = fnCarpeta.listFiles();

            if (fnArchivos != null) {
                System.out.println("\n[+] Listado de especialidades");
                for (File fnArchivo : fnArchivos) {
                    if (fnArchivo.isFile()) {
                        try (BufferedReader br = new BufferedReader(new FileReader(fnArchivo))) {
                            String fnLinea;
                                    
                            while ((fnLinea = br.readLine()) != null) {
                                String[] fnArrayStr = fnLinea.split(";");
                                
                                for (int i = 0; i < fnArrayStr.length; i++) {
                                    
                                    super.fnEspecialidad.add(fnArrayStr[1] + " - " + fnArrayStr[3] + "   " + fnArrayStr[2]);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("No hay elementos dentro de la carpeta actual.");

                    }

                }
            }
            super.fnEspecialidad.remove("Codigo - Paral   Materia");
            for (String fnMateria : super.fnEspecialidad) {
                System.out.println(fnMateria);
            }
        }
    }

    @Override
    public void fnShowEspecialidad() {

    }

    @Override
    public void fnShowMedicos() {
        File fnCarpeta = new File("src\\BL\\Horarios");
        System.out.println(fnCarpeta.exists());
        if (fnCarpeta.isDirectory()) {
            File[] fnArchivos = fnCarpeta.listFiles();

            if (fnArchivos != null) {
                System.out.println("\n[+] Listado de médicos");
                for (File fnArchivo : fnArchivos) {
                    if (fnArchivo.isFile()) {
                        String fnNombre = fnArchivo.getName();
                        int fnIndiceExtension = fnNombre.lastIndexOf(".");
                        if (fnIndiceExtension != -1) {
                            fnNombre = fnNombre.substring(0, fnIndiceExtension);
                            System.out.println("- " + fnNombre);
                        }

                    }
                }
            } else {
                System.out.println("No hay elementos dentro de la carpeta actual.");

            }

        }


    }
}
