package ad07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String fichero = "alumnos.dat";
        Alumno alu = new Alumno("Pepe", "Grillo", 123323, "374374", "fecha");
        Alumno alu2 = new Alumno("Pepe", "Grillo", 123323, "374374", "fecha");
        Alumno alu3 = new Alumno("Pepe", "Grillo", 123323, "374374", "fecha");
        alumnos.add(alu);
        alumnos.add(alu2);
        alumnos.add(alu3);
       serializar(alumnos, fichero);
        deserializar(fichero);
    }
    public static void serializar(ArrayList<Alumno> alumnos, String fichero){
        try {
            ObjectOutputStream serializador = new ObjectOutputStream(new FileOutputStream(fichero));
            serializador.writeObject(alumnos);
            System.out.println("Fichero serializado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deserializar(String fichero){
        List<Alumno> alumnos = null;
        try {
            ObjectInputStream deserializador = new ObjectInputStream(new FileInputStream(fichero));
            alumnos = (ArrayList<Alumno>) deserializador.readObject();
            for (Alumno alumno : alumnos) {
                System.out.println(alumno);
            }
            System.out.println("fichero deserializado");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
