package concatenadordearchivos;

import java.io.*;

public class App1 {
    public static void main(String[] args){
       String fichero1 = args[0];
       String fichero2 = args[1];
       String fichero3 = "combinado.txt";

        combinarFicheros(fichero1, fichero2, fichero3);
    }

    private static void combinarFicheros(String fichero1, String fichero2, String fichero3) {
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(fichero1));
            BufferedReader br2 = new BufferedReader(new FileReader(fichero2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero3));
            String linea1;
            String linea2;
            while((linea1 = br1.readLine())!=null && (linea2 = br2.readLine())!=null){
                bw.write(linea1);
                bw.newLine();
                bw.write(linea2);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
