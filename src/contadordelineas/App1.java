package contadordelineas;

import java.io.BufferedReader;
import java.io.FileReader;

public class App1 {
    public static void main(String[] args) {
     String fichero = args[0];
     int lineas = 0;
     try {
         BufferedReader br = new BufferedReader(new FileReader(fichero));
         String linea;
         while((linea = br.readLine())!=null){
             lineas++;
         }
         br.close();

     } catch (java.io.IOException e) {
         throw new RuntimeException(e);
     }
        System.out.println("El fichero tiene " + lineas + " lineas");
    }
}
