package ad03;

import java.io.*;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder correo = new StringBuilder();
        System.out.println("Introduce un destinatario: ");
        correo.append(sc.nextLine() + " ");
        System.out.println("Introduce un asunto: ");
        correo.append(sc.nextLine() + " ");
        System.out.println("Introduce un cuerpo del correo: ");
        correo.append(sc.nextLine());

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("correo.dat"));
            dos.writeUTF(correo.toString());
            DataInputStream dis = new DataInputStream(new FileInputStream("correo.dat"));
            System.out.println(dis.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
