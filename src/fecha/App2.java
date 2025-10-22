package fecha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App2 {
    public static void main(String[] args) {
        String hijo = "fecha.App1";

        try {
            for (int i = 0; i < 3; i++) {
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), hijo, "fecha.txt");
                Process p = pb.start();
                p.waitFor();
                Thread.sleep(100);

            }
            BufferedReader br = new BufferedReader(new FileReader("fecha.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
