package alfaroviquez.david.iu;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Clase IU (Interfaz de Usuario)
 * En esta clase se crean los metodos para mostrar datos en consola y capturar los datos del usuario
 *
 * @author David Alfaro Viquez
 * @version 1.0
 * @since 23/10/2020
 */
public class IU {

    PrintStream output = new PrintStream(System.out);
    Scanner input = new Scanner(System.in).useDelimiter("\n");

    /**
     * Metodo para mostrar el menu en consola
     */
    public void mostrarMenu(){
        output.println("///////Gestor de Facturas//////////");
        output.println("1. Registrar cliente");
        output.println("2. Registrar producto");
        output.println("3. Crear factura");
        output.println("4. Imprimir factura");
        output.println("5. Listar Clientes");
        output.println("6. Listar productos");
        output.println("7. Salir");
    }

    /**
     * Funcion para leer el texto que el usuario digita en consola
     * @return el texto digitado por el usuario
     */
    public String leerTexto(){
        return input.next();
    }

    /**
     * Funcion para leer un entero que el usuario ingrese en consola
     * @return el numero entero ingresado por el usuario
     */
    public int leerNumero(){
        output.println("Su opcion es-->");
        return input.nextInt();
    }

    /**
     * Mtodo para imprimir un mensaje en consola
     * @param msg es el mensaje que se va a imprimir
     */
    public void imprimirMensaje(String msg){
        output.println(msg);
    }
}
