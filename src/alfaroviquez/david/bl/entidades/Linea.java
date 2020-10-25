package alfaroviquez.david.bl.entidades;

/**
 * Clase Linea
 * Para crear diferentes lineas de detalle en una factura
 *
 * @author David Alfaro Viquez
 * @version 1.0
 * @since 23/10/2020
 */
public class Linea {
    private Producto producto;
    private int cantidad;

    /**
     * Metodo get para producto
     * @return objeto de tipo producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Metodo set para producto
     * @param producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Metodo get para la cantidad de producto
     * @return la cantidad de un procuto en una linea de detalle
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Metodo set para la cantidad de producto en una linea de detalle
     * @param cantidad de producto en una linea
     */

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Linea() {
    }

    /**
     * Constructor para linea
     *
     * @param producto instancia de la clase producto
     * @param cantidad cantidad de producto en una linea, tipo entero
     */
    public Linea(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * Funcion para calcular el costo de una linea en una factura
     * @return el costo total de una linea de detalle en una factura
     */
     public double calcularCosto(){
        double costo = 0;
        costo = this.cantidad*producto.getPrecio();
        return costo;
     }

    @Override
    public String toString() {
        String msg;
        msg=cantidad+"\t\t\t\t";
        msg=msg+producto.getCodigo()+"\t\t\t\t";
        msg=msg+producto.getDescripcion()+"\t\t\t";
        msg=msg+producto.getPrecio()+"\t\t\t";
        msg=msg+this.calcularCosto();
        return msg;
    }
}
