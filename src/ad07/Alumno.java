package ad07;

import java.io.Serializable;

public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String apellidos;
    private int nre;
    private String telefono;
    private String fecha;

    public Alumno(String nombre, String apellidos, int nre, String telefono, String fecha) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nre = nre;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNre() {
        return nre;
    }

    public void setNre(int nre) {
        this.nre = nre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nre=" + nre +
                ", telefono='" + telefono + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
