package sumaporcanal;

import java.io.*;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "sumaporcanal.App2";
        System.out.println("cuantos numeros quieres sumar? ");
        int cantidad = sc.nextInt();
        int num;
            try {
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), path);
                Process p = pb.start();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
                for (int i = 0; i < cantidad; i++) {
                    System.out.println("Introduce un numero: ");
                    num = sc.nextInt();
                    bw.write(Integer.toString(num));
                    bw.newLine();
                }
                bw.flush();
                bw.close();
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }}
