package repasoad.ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> palabras = new ArrayList<>();
        palabras.add("Madrid");
        palabras.add("Zaragoza");
        palabras.add("Barcelona");
        guardarFichero("palabras.txt", palabras, 'a');

    }

    public static void guardarFichero(String nombreFichero, ArrayList<String> palabras, char ordenacion) {
        File f = new File(nombreFichero);
        if (!f.exists()) {
            switch (ordenacion) {
                case 'a':
                    ordenarAscendente(palabras);
                    break;
                case 'd':
                    ordenarDescendente(palabras);
                    break;
            }
            try {
                int contador = 0;
                BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));
                for (String palabra : palabras) {
                    bw.write(palabra);
                    contador++;
                    bw.newLine();
                }
                bw.write("hay " + contador + " palabras");
                bw.flush();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("El fichero no debe existir");
            return;
        }
    }

    public static void ordenarAscendente(ArrayList<String> palabras) {
        Collections.sort(palabras);
    }

    public static void ordenarDescendente(ArrayList<String> palabras) {
        Collections.sort(palabras, Collections.reverseOrder());
    }
}
