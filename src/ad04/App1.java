package ad04;

import java.io.*;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del fichero: ");
        String nombreFichero = sc.nextLine();
        System.out.println("Introduce una palabra: ");
        String palabra = sc.nextLine();

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));
            bw.write("milena ");
            bw.newLine();
            bw.write("dani y lupita ");
            bw.close();
            System.out.println("la palabra "+ palabra + " en la linea" + linea(nombreFichero, palabra));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static int linea(String nombreFichero, String palabra) {
        int contador = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String line;
            while ((line = br.readLine()) != null) {
                contador++;
                if(line.contains(palabra)){
                    return contador;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
}
