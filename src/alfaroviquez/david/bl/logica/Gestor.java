package alfaroviquez.david.bl.logica;

import alfaroviquez.david.bl.entidades.Cliente;
import alfaroviquez.david.bl.entidades.Factura;
import alfaroviquez.david.bl.entidades.Linea;
import alfaroviquez.david.bl.entidades.Producto;
/**
 * Clase Gestor
 * En esta clase se tiene toda la logica del programa
 * Esta clase se usa para poder crear las instancias de los diversos objetos, guardarlos en arraylist, y listarlos
 *
 * @author David Alfaro Viquez
 * @version 1.0
 * @since 23/10/2020
 */


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

    /**
     * En este metodo se invoca al constructor de la clase cliente para crear instancias de clientes
     * Se usa el metodo contains para verificar si el cliente ya existe, si no existe se agrega al arraylist clientes
     *
     * @param nombre del cliente, String
     * @param identificacion del cliente, String
     * @param genero del cliente, String
     * @param fechaNac del cliente, String
     */
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

    /**
     * Metodo para crear instancias de la clase producto
     * El metodo crea la instancia y la guarda dentro del arraylist productos
     *
     * @param codigo del producto, String
     * @param descripcion del producto, String
     * @param precio del producto, double
     */

    public void crearProducto(String codigo, String descripcion, double precio) {
        Producto nuevoProducto = new Producto(codigo, descripcion, precio);
        productos.add(nuevoProducto);
    }

    /**
     * Metodo para agregar una factura al arraylist facturas
     *
     * @param fact obtjeto de tipo factura
     */
    public void guardarFactura(Factura fact){
        facturas.add(fact);
    }


    /**
     * Funcion para buscar un cliente en el arraylist clientes
     * La busqueda se realiza con base en la identificacion del cliente
     *
     * @param identificacion del cliente, String
     * @return un objeto de tipo Cliente
     */
    public Cliente buscarCliente(String identificacion) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteActual = clientes.get(i);
            if(clienteActual.getIdentificacion().equals(identificacion)){
                return clienteActual;
            }
        }
        return null;
    }

    /**
     * Funcion para buscar productos en el araylist productos
     * La busqueda se realiza mediante el codigo del producto
     *
     * @param codigo del producto, String
     * @return un objeto de tipo producto
     */
     public Producto buscarProducto(String codigo){
        for(int i=0;i<productos.size();i++){
            Producto prodActual = productos.get(i);
            if(prodActual.getCodigo().equalsIgnoreCase(codigo)){
                return prodActual;
            }
        }
        return null;
     }

    /**
     * Funcion para listar Facturas
     *
     * @return los elementos que estan dentro del arraylist facturas
     */
    public ArrayList<Factura> listarFacturas(){
        return this.facturas;
    }
    /**
     * Funcion para listar Clientes
     *
     * @return los elementos que estan dentro del arraylist clientes
     */
    public ArrayList<Cliente> listarClientes(){
        return this.clientes;
    }
    /**
     * Funcion para listar Productos
     *
     * @return los elementos que estan dentro del arraylist productos
     */
    public ArrayList<Producto> listarProductos(){
        return this.productos;
    }

}

