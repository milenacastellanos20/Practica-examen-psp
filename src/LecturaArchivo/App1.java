package LecturaArchivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App1 {
    public static void main(String[] args) {
        String archivo = args[0];
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
