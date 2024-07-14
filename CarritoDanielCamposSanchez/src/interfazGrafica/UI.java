package interfazGrafica;

import capaLogica.CL;
import capaLogica.Producto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class UI {

    static PrintStream out = System.out;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static CL cl = new CL();

    public static void main(String[] args) throws IOException {
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = seleccionarOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    public static void mostrarMenu() {

        out.println("1. Registrar Prductos");
        out.println("2. Ver Prductos");
        out.println("3. Comprar Productos");
        out.println("4. Imprimir Carrito");
        out.println("0. Salir");
    }

    public static int seleccionarOpcion() throws IOException {
        int opcion = 0;
        out.println("Digite la opción a ejecutar");
        opcion = Integer.parseInt(in.readLine());
        return opcion;
    }

    public static void procesarOpcion(int opcion) throws IOException {
        switch (opcion) {
            case 1:
                RegistrarProducto();
                break;
            case 2:
                VerProductos();
                break;
            case 3:
                ComprarProductos();
                break;
            case 4:
                ImprimirCarrito();
                break;
            case 0:
                break;
            default:
                out.println("Opción inválida");
                break;
        }
    }

    public static void RegistrarProducto() throws IOException {
        out.println("Ingresar la información del producto");
        out.println("Ingresar el codigo del producto");
        String codigo = in.readLine();
        out.println("Ingresar el nombre del producto");
        String nombre = in.readLine();
        out.println("Ingresar la descripcion del producto");
        String descripcion = in.readLine();
        out.println("Ingresar el precio del producto");
        int precio = Integer.parseInt(in.readLine());
        Producto producto = new Producto(codigo, nombre, descripcion, precio);
        cl.registrarProducto(producto);
    }

    public static void VerProductos() throws IOException {
        out.println("----Informacion de productos----");
        cl.verProductos();
    }

    public static void ComprarProductos() throws IOException {
        boolean compraProducto = true;
        do {
            out.println("----Productos Disponibles----");
            cl.imprimirTodosLosProductos();
            out.println("Ingresar el codigo del producto que quiere comprar");
            Producto producto = cl.obtenerProductoPorCodigo(in.readLine());
            out.println("Ingresar la cantidad de productos de este codigo que desea comprar");
            int cantidad = Integer.parseInt(in.readLine());
            cl.registrarProductosComprados(producto, cantidad);
            out.println("Producto comprado: " + producto);
            out.println("------------------------------");
            out.println("Quiere comprar otro producto? S/N");
            if(!in.readLine().toUpperCase().equals("S"))
                compraProducto = false;
        }while (compraProducto);
    }

    public static void ImprimirCarrito() throws IOException {
        cl.imprimirCarrito();
    }
}
