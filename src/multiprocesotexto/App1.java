package multiprocesotexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App1 {
    private static final String FICHERO = "palabras.txt";
    public static void main(String[] args) {
        String palabra = args[0];
        try {
            FileWriter fw = new FileWriter(FICHERO, true);
            fw.write(palabra + "\n");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
