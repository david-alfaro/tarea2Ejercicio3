package alfaroviquez.david.controlador;

import alfaroviquez.david.bl.entidades.Cliente;
import alfaroviquez.david.bl.entidades.Factura;
import alfaroviquez.david.bl.entidades.Linea;
import alfaroviquez.david.bl.entidades.Producto;
import alfaroviquez.david.bl.logica.Gestor;
import alfaroviquez.david.iu.IU;

import java.time.LocalDate;

/**
 * Clase controlador
 * Para tomar los valores del usuario y enviarlos al gestor para crear las instancias de cada clase
 *
 * @author David Alfaro Viquez
 * @version 1.0
 * @since 23/10/2020
 */
public class Controlador {
    Gestor gestor = new Gestor();
    IU iu = new IU();

    /**
     * Metodo para ejecutar el programa
     * Muestra el menu en pantalla
     * Procesa la opcion ingresada por el usuario
     */
    public void ejecutarPrograma() {
        int opcion = 0;
        do {
            iu.mostrarMenu();
            opcion = iu.leerNumero();
            procesarOpcion(opcion);
        } while (opcion != 7);
    }

    /**
     * Esta funcion procesa la opcion escogida por el usuario
     * Dependdiendo de la opcion escogida se ejecuta una determinada funcion
     *
     * @param opcion ingresada por el usurio, es un numero entero
     */
    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarCliente();
                break;
            case 2:
                registrarProducto();
                break;
            case 3:
                registrarFactura();
                break;
            case 4:
                imprimirFactura();
                break;
            case 5:
                listarClientes();
                break;
            case 6:
                listarProductos();
                break;
            case 7:
                break;
            default:
                iu.imprimirMensaje("Opcion invalida");
        }
    }

    /**
     * Metodo para registrar clientes
     */
    private void registrarCliente() {
        iu.imprimirMensaje("Registrar cliente--->");
        iu.imprimirMensaje("Nombre del cliente: ");
        String nombreCliente = iu.leerTexto();
        iu.imprimirMensaje("Numero de identificacion: ");
        String identificacion = iu.leerTexto();
        iu.imprimirMensaje("Genero (M/F)");
        String genero = iu.leerTexto();
        iu.imprimirMensaje("Fecha de nacimiento (dd/MM/yyyy): ");
        String fechaNac = iu.leerTexto();
        gestor.crearCliente(nombreCliente, identificacion, genero, fechaNac);
        iu.imprimirMensaje("Cliente registrado con exito");
    }

    /**
     * Metodo para listar clientes
     */
    private void listarClientes() {
        for (Cliente cliente : gestor.listarClientes()
        ) {
            iu.imprimirMensaje(cliente.toString());
        }
    }

    /**
     * Metodo para registrar productos
     */
    private void registrarProducto() {
        iu.imprimirMensaje("Registrar producto nuevo--->");
        iu.imprimirMensaje("Codigo del producto: ");
        String codigo = iu.leerTexto();
        iu.imprimirMensaje("Descripcion del producto: ");
        String descripcion = iu.leerTexto();
        iu.imprimirMensaje("Precio del producto: ");
        double precio = iu.leerNumero();
        gestor.crearProducto(codigo, descripcion, precio);
        iu.imprimirMensaje("Producto registrado con exito");
    }

    /**
     * metodo para listar productos
     */
    private void listarProductos() {
        for (Producto producto : gestor.listarProductos()
        ) {
            iu.imprimirMensaje(producto.toString());
        }
    }

    /**
     * Metodo para crear una nueva factura
     */
    private void registrarFactura() {
        iu.imprimirMensaje("Registrar factura--->");
        iu.imprimirMensaje("Numero de identificacion del cliente: ");
        String identificacion = iu.leerTexto();
        Cliente uncliente = gestor.buscarCliente(identificacion);
        LocalDate fecha = LocalDate.now();
        Factura nuevaFactura = new Factura();
        nuevaFactura.setFecha(fecha);
        nuevaFactura.setCliente(uncliente);
        boolean agregarlinea=true;
        while(agregarlinea){
            iu.imprimirMensaje("Codigo del produto a facturar: ");
            String codigo = iu.leerTexto();
            Producto producto = gestor.buscarProducto(codigo);
            iu.imprimirMensaje("Cantidad del producto: ");
            int cant = iu.leerNumero();
            Linea nuevaLinea = new Linea(producto,cant);
            nuevaFactura.getLineasDetalle().add(nuevaLinea);
            iu.imprimirMensaje("Desea agregar otra linea (s/n)");
            String respuesta = iu.leerTexto();
            if(respuesta.equalsIgnoreCase("n")){
                agregarlinea=false;
            }
        }
        gestor.guardarFactura(nuevaFactura);
        iu.imprimirMensaje("Factura creada");

    }

    /**
     * Metodo para imprimir una factura en consola
     */

    private void imprimirFactura() {
        for (Factura fac : gestor.listarFacturas()
        ) {
            iu.imprimirMensaje(fac.toString());
        }
    }


}
