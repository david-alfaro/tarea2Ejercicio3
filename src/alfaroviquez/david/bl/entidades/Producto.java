package alfaroviquez.david.bl.entidades;

/**
 * Clase Producto
 * Esta clase se utiliza para poder crear diferentes productos que se van a facturar
 * Para crear un producto es necesario indicar su codigo, descripcion y precio
 *
 * @author David Alfaro Viquez
 * @version 1.0
 * @since 23/10/2020
 */
public class Producto {
    private String codigo;
    private String descripcion;
    private double precio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto() {
    }

    /**
     * Constructor de la clase
     *
     * @param codigo del prodcuto, es un String
     * @param descripcion del producto, es un String
     * @param precio del producto, es un double
     */
    public Producto(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
