package masyusculasentreprocesos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "masyusculasentreprocesos.App2";
        String frase;
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), path);

        do {
            System.out.println("Introduce una frase: ");
            frase = sc.nextLine();
            if (!frase.equals("fin")) {
                try {
                    Process p = pb.start();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
                    bw.write(frase);
                    bw.newLine();
                    bw.flush();

                    bw.close();

                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    p.waitFor();
                    br.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else {
                break;
            }
        } while (!frase.contains("fin"));
    }
}
