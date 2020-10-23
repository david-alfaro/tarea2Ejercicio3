package alfaroviquez.david.iu;

import java.io.PrintStream;
import java.util.Scanner;

public class IU {

    PrintStream output = new PrintStream(System.out);
    Scanner input = new Scanner(System.in).useDelimiter("\n");

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

    public String leerTexto(){
        return input.next();
    }
    public int leerNumero(){
        output.println("Su opcion es-->");
        return input.nextInt();
    }
    public void imprimirMensaje(String msg){
        output.println(msg);
    }
}
