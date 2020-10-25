package alfaroviquez.david.bl.entidades;
/**
 * Clase Cliente
 *
 * @author David Alfaro Viquez
 * @version 1.0
 * @since 23/10/2020
 */

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Cliente {
    private String nombre;
    private String identificacion;
    private String genero;
    private String fechaNacimiento;

    /**
     * Metodo Get para Nombre del cliente
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo set para nombre del cliente
     * @param nombre del cliente es un parametro string
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo get para la identificacion del cliente
     * @return el numero de indentificacion del cliente
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Metodo set para la identificacion del cliente
     * @param identificacion del cliente es un String
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Metodo get para el genero del cliente
     * @return el genero del cliente
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Metodo set para el genero del cliente
     * @param genero del cliente es un string
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Metodo get para la fecha de nacimiento del cliente
     * @return la fecha de nacimiento como un string
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Metodo set para la fecha de nacimiento
     * @param fechaNacimiento del cliente es un string
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente() {
    }

    /**
     * Constructor Cliente
     *
     * @param nombre del cliente es un string
     * @param identificacion del cliente es un string
     * @param genero del cliente es un string
     * @param fechaNacimiento del cliente es un string
     */

    public Cliente(String nombre, String identificacion, String genero, String fechaNacimiento) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;

    }

    /**
     * Funcion para transformar la fecha de nacimiento del cliente de string a localdate
     * @return la fecha de nacimiento en tipo localdate
     */
    public LocalDate getFechaNacimiennto(){
        String FechaNac=this.fechaNacimiento;
        LocalDate fecha;
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fecha = LocalDate.parse(FechaNac,formatter);
        return fecha;
    }

    /**
     * Funcion para obtener la edad del cliente
     * Se toma la fecha de nacimiento y se le resta a la fecha actual indicada por el servidor
     * @return la edad del cliente
     */
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
