package alfaroviquez.david.bl.entidades;

public class Linea {
    private Producto producto;
    private int cantidad;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Linea() {
    }

    public Linea(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
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
