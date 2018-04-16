
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mateo Marin
 */
public class TesterMenu {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;	// variables objetos in y out para

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static boolean noSalir = true;

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        out.println("Diario Facil");
        int opc;

        boolean noSalir;

        do {
            mostrarMenu();
            opc = leerOpcion();
            noSalir = ejecutarAccion(opc);
        } while (noSalir);
    }

    public static void mostrarMenu() {

        out.println();
        out.println("1. Login");
        out.println("2. Registro");
        out.println("3. Salir");
        out.println();
    }

    public static int leerOpcion() throws java.io.IOException {

        int opcion;

        out.print("Seleccione su opción: ");
        opcion = Integer.parseInt(in.readLine());
        out.println();

        return opcion;
    }

    public static boolean ejecutarAccion(int popcion) throws java.io.IOException {

        boolean noSalir = false;
        int numProd = 0;

        switch (popcion) {

            case 1: //Opcion Agregar Producto

                noSalir = login();
                break;

            case 2:// Modificar Producto

                out.println();
                registro();
                break;
            case 3://Salir
                out.println("Gracias por usar Diario Facil");
                noSalir = false;
                break;

            default: //Cualquier otro valor dado por el usuario se considera inválido

                out.println("Opcion inválida");
                out.println();
                break;
        }
        return noSalir;
    }

    public static boolean login() throws IOException {
        Scanner leer = new Scanner(System.in);
        //CARGA DE DATOS
        DiarioFacil df = new DiarioFacil();

        Usuario cliente1 = new Cliente("Mateo Marin", "mateo123", "12345678", "12345679", "Heredia");

        Usuario cliente2 = new Cliente("Luis Fernandez", "luis123", "12345679", "9876543", "San Jose");

        Usuario cliente3 = new Cliente("Antonio Alvarez", "antonio123", "12345677", "9786545", "Alajuela");

        Usuario adm = new Administrador("Pedro Marin", "pedro123", "123123123", "34534534", "Caratago");

        df.agregarUsuario(cliente1);
        df.agregarUsuario(cliente2);
        df.agregarUsuario(cliente3);
        df.agregarUsuario(adm);

        int cod;
        out.println("1. Como administrador\n");
        out.println("2. Como usuario\n");
        out.println("3. Salir\n");
        out.println("Digite la opcion: \n");
        cod = leer.nextInt();
        switch (cod) {
            case 1:
                out.println("Digite su usuario de administrador : \n");
                String user = in.readLine();
                out.println("Digite su pass: \n");
                String pass = in.readLine();
                for (Usuario usuario : df.getLstUsuarios()) {
                    if (user.equals(usuario.getNombre()) && pass.equals(usuario.getContraseña())) {
                        if (usuario instanceof Administrador) {
                            mostrarMenuAdministrador();
                        } else {
                            out.println("Escogiste la opcion incorrecta. Por favor escoja otra vez");
                            login();
                            break;
                        }
                    }
                }
                break;
            case 2:
                out.println("Digite su usuario: \n");
                String user1 = in.readLine();
                out.println("Digite su contraseña: \n");
                String pass1 = in.readLine();
                for (Usuario usuario : df.getLstUsuarios()) {
                    if (user1.equals(usuario.getNombre()) && pass1.equals(usuario.getContraseña())) {
                        if (usuario instanceof Cliente) {
                            mostrarMenuCliente();
                        } else {
                            out.println("Escogiste la opcion incorrecta. Por favor escoja otra vez");
                            login();
                        }
                    }
                }
                break;
            case 3:
                mostrarMenu();
                break;
            default:
                out.println("Valor no valido");
                break;
        }
        return login();
    }

    public static void registro() throws IOException {
        out.println("Digite un nombre : ");

    }

    public static void mostrarMenuAdministrador() throws IOException {
        out.println("Hola administrador");
        Scanner leer = new Scanner(System.in);
        int cod;
        out.println("1. Mantenimiento Producto\n");
        out.println("2. Mantenimiento Categoria\n");
        out.println("3. Mantenimiento Clientes\n");
        out.println("4. Mantenimiento de Proveedores\n");
        out.println("5. Mantenimiento de Pedidos\n");
        out.println("6. Salir");
        out.println("Digite la opcion: ");
        cod = leer.nextInt();
        switch (cod) {
            case 1:
                mantenimientoProducto();
                break;
            case 2:
                mantenimientoCategoria();
                break;
            case 3:
                //mantenimientoClientes();
                break;
            case 4:
                //mantenimientoProveedores();
                break;
            case 5:
                //mantenimientoPedidos();
                break;
            case 6:
                login();
                break;
        }
    }

    public static void mantenimientoProducto() throws IOException {
        Scanner leer = new Scanner(System.in);
        int cod;
        out.println("1. Agregar Producto\n");
        out.println("2. Modificar Producto\n");
        out.println("3. Eliminar Producto\n");
        out.println("4. Salir\n");
        out.println("Digite la opcion: ");
        cod = leer.nextInt();
        switch (cod) {

            case 1:
                static <T> void;
                break;

            case 2:
                break;

            case 3:
                break;
            case 4:
                mostrarMenuAdministrador();
                break;
            default:
                out.println("Opcion no valida");
        }
        if (cod != T) {
            mantenimientoProducto();
        }
    }

    public static void mantenimientoCategoria() throws IOException {
        Scanner leer = new Scanner(System.in);
        int cod;
        out.println("1. Agregar Categoria\n");
        out.println("2. Modificar Categoria\n");
        out.println("3. Eliminar Categoria\n");
        out.println("4. Salir\n");
        out.println("Digite la opcion: ");
        cod = leer.nextInt();
        switch (cod) {

            case 1:
                break;

            case 2:
                break;

            case 3:
                break;
            case 4:
                mostrarMenuAdministrador();
                break;
            default:
                out.println("Opcion no valida");
        }
        if (cod != 4) {
            mantenimientoProducto();
        }
    }

    public static void mostrarMenuCliente() {
        out.println("Hola cliente");
    }

}
