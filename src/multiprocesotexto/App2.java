package multiprocesotexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "multiprocesotexto.App1";
        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce una palabra");
            String palabra = sc.nextLine();
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), path, palabra);
            try {
                Process p = pb.start();
                p.waitFor();

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
