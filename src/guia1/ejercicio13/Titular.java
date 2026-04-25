package guia1.ejercicio13;

import java.time.LocalDate;

public class Titular {
    private String DNI;
    private String nombre;
    private String apellido;
    private LocalDate fechaDeNacimiento;
    private String domicilio;

    public Titular(String DNI, String nombre, String apellido, LocalDate fechaDeNacimiento, String domicilio) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.domicilio = domicilio;
    }

    public String nombreCompleto(){
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return "Titular{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento=" + fechaDeNacimiento + ", domicilio=" + domicilio + '}';
    }


}