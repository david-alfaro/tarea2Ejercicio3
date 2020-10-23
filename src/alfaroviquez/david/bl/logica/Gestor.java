package alfaroviquez.david.bl.logica;

import alfaroviquez.david.bl.entidades.Cliente;
import alfaroviquez.david.bl.entidades.Factura;
import alfaroviquez.david.bl.entidades.Linea;
import alfaroviquez.david.bl.entidades.Producto;



import java.util.ArrayList;


public class Gestor {
    ArrayList<Cliente> clientes;
    ArrayList<Producto> productos;
    ArrayList<Factura> facturas;

    public Gestor() {
        this.clientes = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public void crearCliente(String nombre, String identificacion, String genero, String fechaNac) {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setIdentificacion(identificacion);
        nuevoCliente.setGenero(genero);
        nuevoCliente.setFechaNacimiento(fechaNac);
        if (clientes.contains(nuevoCliente)) {
            System.out.println("El cliente ya existe");
        } else {
            clientes.add(nuevoCliente);
        }


    }

    public void crearProducto(String codigo, String descripcion, double precio) {
        Producto nuevoProducto = new Producto(codigo, descripcion, precio);
        productos.add(nuevoProducto);
    }

    public void guardarFactura(Factura fact){
        facturas.add(fact);
    }



    public Cliente buscarCliente(String identificacion) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteActual = clientes.get(i);
            if(clienteActual.getIdentificacion().equals(identificacion)){
                return clienteActual;
            }
        }
        return null;
    }
     public Producto buscarProducto(String codigo){
        for(int i=0;i<productos.size();i++){
            Producto prodActual = productos.get(i);
            if(prodActual.getCodigo().equalsIgnoreCase(codigo)){
                return prodActual;
            }
        }
        return null;
     }

    public ArrayList<Factura> listarFacturas(){
        return this.facturas;
    }
    public ArrayList<Cliente> listarClientes(){
        return this.clientes;
    }
    public ArrayList<Producto> listarProductos(){
        return this.productos;
    }

}

