package alfaroviquez.david.bl.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

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

    public Factura(Cliente cliente, LocalDate fecha, ArrayList<Linea> lineasDetalle) {
        this.numero = contador;
        this.cliente = cliente;
        this.fecha = fecha;
        this.lineasDetalle = lineasDetalle;
    }

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

    private float calcularImpuesto() {
        float impuesto;
        impuesto = (float) (calcularSubTotal() * 0.13);
        return impuesto;
    }

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
