package alfaroviquez.david.bl.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase Factura
 * Crear instancias de la clase Factura
 *
 * @author David Alfaro Viquez
 * @version 1.0
 * @since 23/10/2020
 */
public class Factura {
    private static int contador;
    private int numero;
    private Cliente cliente;
    private LocalDate fecha;
    private ArrayList<Linea> lineasDetalle = new ArrayList<>();

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Linea> getLineasDetalle() {
        return lineasDetalle;
    }

    public void setLineasDetalle(ArrayList<Linea> lineasDetalle) {
        this.lineasDetalle = lineasDetalle;
    }

    public Factura() {
        contador++;
    }

    /**
     * Constructor de la clase Factura
     *
     * @param cliente cliente de la actura, instancia de la clase Cliente
     * @param fecha en la que se emite la  factura
     * @param lineasDetalle las lineas de detalle de la factura
     */
    public Factura(Cliente cliente, LocalDate fecha, ArrayList<Linea> lineasDetalle) {
        this.numero = contador;
        this.cliente = cliente;
        this.fecha = fecha;
        this.lineasDetalle = lineasDetalle;
    }

    /**
     * Funcion para calcular el subtotal de la factura, el monto antes de los intereses
     * Un metodo de la clase Linea es calcularCosto, este metodo se usa para calcular el costo de una linea
     * En esta funcion se invoca este metodo y se realiza la suma de los costos de todas las lineas
     *
     * @return el subtotal de la factura
     */
    private float calcularSubTotal() {
        Linea lineaDetalle;
        float subtotal;
        subtotal = 0;
        for (int i = 0; i < lineasDetalle.size(); i++) {
            lineaDetalle = lineasDetalle.get(i);
            subtotal = (float) (subtotal + lineaDetalle.calcularCosto());
        }
        return subtotal;
    }

    /**
     * Funcion para calcular el impuesto de una factura
     * Toma el subtotal y lo multiplica por el impuesto de 13%
     * @return el valor del imouesto, float
     */
    private float calcularImpuesto() {
        float impuesto;
        impuesto = (float) (calcularSubTotal() * 0.13);
        return impuesto;
    }

    /**
     * Funcion para cacular el total de una fatura
     * Esto se calcula sumando el subtotal con el impuesto
     *
     * @return el monto total del impuesto dato de tipo float
     */
    private float calcularTotal() {
        float total;
        total = calcularSubTotal() + calcularImpuesto();
        return total;
    }

    @Override
    public String toString() {
        String msg;
        Linea LineaD;
        msg = "=================================================" + "\n";
        msg = msg + "Armaduras Medievales. SA";
        msg = msg + "\t\t" + "No. " + numero + "\n";
        msg = msg + "Cliente: " + cliente + " ";
        msg = msg + "Fecha: " + fecha + " \n";
        msg = msg + "----------------------------------------------" + "\n";
        msg = msg + "cant " + "\t\t\t" + "codigo" + "\t\t\t" + "descrip" + "\t\t\t" + "precio" + "\t\t" + "costo" + "\n";
        for (int i = 0; i < lineasDetalle.size(); i++) {
            LineaD = lineasDetalle.get(i);
            msg = msg + LineaD.toString() + "\n";
        }
        msg = msg + "\t\t\t\t" + "----------------" + "\n";
        msg = msg + "\t\t\t\t" + "subtotal " + this.calcularSubTotal() + "\n";
        msg = msg + "\t\t\t\t" + "impuesto " + this.calcularImpuesto() + "\n";
        msg = msg + "\t\t\t\t" + "total " + this.calcularTotal() + "\n";
        msg =msg+ "=================================================" + "\n";
        return msg;
    }
}
