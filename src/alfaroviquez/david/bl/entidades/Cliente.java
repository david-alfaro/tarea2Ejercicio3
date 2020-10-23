package alfaroviquez.david.bl.entidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Cliente {
    private String nombre;
    private String identificacion;
    private String genero;
    private String fechaNacimiento;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente() {
    }

    public Cliente(String nombre, String identificacion, String genero, String fechaNacimiento) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;

    }
    public LocalDate getFechaNacimiennto(){
        String FechaNac=this.fechaNacimiento;
        LocalDate fecha;
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fecha = LocalDate.parse(FechaNac,formatter);
        return fecha;
    }

    public int getEdad(){
        LocalDate fechaNac=getFechaNacimiennto();
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fechaNac,hoy);
        return edad.getYears();
    }


    @Override
    public String toString() {
        String msg;
        msg=nombre+"\t";
        msg=msg+"Identificacion: "+identificacion+"\t\t";
        msg=msg+"Genero: "+genero+"\t";
        msg=msg+"Fecha Nacimiento: "+fechaNacimiento+"\t";
        msg=msg+"Edad: "+this.getEdad();
        return msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) &&
                Objects.equals(identificacion, cliente.identificacion) &&
                Objects.equals(genero, cliente.genero) &&
                Objects.equals(fechaNacimiento, cliente.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, identificacion, genero, fechaNacimiento);
    }
}
