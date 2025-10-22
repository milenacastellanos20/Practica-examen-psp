package concatenadordearchivos;

import java.io.IOException;

public class App2 {
    public static void main(String[] args){
        String path = "concatenadordearchivos.App1";
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), path, "fichero.txt", "palabras.txt");
            Process p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
