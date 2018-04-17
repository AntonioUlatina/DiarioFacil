
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

//************************************************
//          CARGA INICIAL DE USUARIOS
//************************************************
    static DiarioFacil dF = new DiarioFacil();
    static Usuario cliente1 = new Cliente("Mateo", "mateo123", "12345678", "12345679", "Heredia");
    static Usuario cliente2 = new Cliente("Luis", "luis123", "12345679", "9876543", "San Jose");
    static Usuario cliente3 = new Cliente("Antonio", "antonio123", "12345677", "9786545", "Alajuela");
    static Usuario adm = new Administrador("Pedro", "pedro123", "123445543", "342423");
    static Proveedor pro1 = new Proveedor("Carlos", "colomasayuja2@gmail.com");
//************************************************
//          FIN DE CARGA USUARIOS
//************************************************

//************************************************
//          CARGA INICIAL DE PRODUCTOS
//************************************************
    static Producto leche = new Producto("Leche", "Lacteos", 400, 5);
    static Producto cerdo = new Producto("Carne de cerdo", "Carnes", 2000, 5);
    static Producto cerveza = new Producto("Cerveza", "Licores", 800, 5);
//************************************************
//************************************************
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;	// variables objetos in y out para
    static int opc;
    static boolean noSalir;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        out.println("Diario Facil");
        noSalir = true;

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

        out.print("Seleccione su opción: ");
        out.println();
        return Integer.parseInt(in.readLine());
    }

    public static boolean ejecutarAccion(int popcion) throws java.io.IOException {

        //noSalir = false;  <==== no deberia estar aqui
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
        //CARGA DE DATOS

        dF.agregarUsuario(cliente1);
        dF.agregarUsuario(cliente2);
        dF.agregarUsuario(cliente3);
        dF.agregarUsuario(adm);
        dF.agregarProducto(leche);
        dF.agregarProducto(cerdo);
        dF.agregarProducto(cerveza);
        Scanner leer = new Scanner(System.in);
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
                for (Usuario usuario : dF.getLstUsuarios()) {
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
                for (Usuario usuario : dF.getLstUsuarios()) {
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
        if (cod != 3) {
            mostrarMenu();
        }
        return true;
        
    }

    public static void registro() throws IOException {
        out.println("Digite un nombre : ");

    }
//************************************************
//          INICIA FLUJO DE MENU ADMINISTRADOR
//************************************************

    public static void mostrarMenuAdministrador() throws IOException {
        out.println("Hola administrador");
        Scanner leer = new Scanner(System.in);
        int cod;
        out.println("1. Mantenimiento Producto\n");
        out.println("2. Mantenimiento Clientes\n");
        out.println("3. Mantenimiento de Proveedores\n");
        out.println("4. Mantenimiento Combo\n");
        out.println("5. Mantenimiento Promociones\n");
        out.println("6. Salir");
        out.println("Digite la opcion: ");
        cod = leer.nextInt();
        switch (cod) {
            case 1:
                mantenimientoProducto();
                break;
            case 2:
                mantenimientoClientes();
                break;
            case 3:
                mantenimientoProveedores();
                break;
            case 4:
                mantenimientoCombo();
            case 5:
                mantenimientoPromociones();
            case 6:
                login();
                break;
        }
    }

    public static void mantenimientoProducto() throws IOException {
        Scanner leer = new Scanner(System.in);
        int cod;
        out.println(dF.getLstProductos());
        out.println("1. Agregar Producto\n");
        out.println("2. Modificar Producto\n");
        out.println("3. Eliminar Producto\n");
        out.println("4. Salir\n");
        out.println("Digite la opcion: ");
        cod = leer.nextInt();
        switch (cod) {

            case 1:
                String nombre;
                String categoria;
                int stockMin;
                double precio;
                out.println("Digite un nombre: ");
                nombre = leer.next();
                out.println("Digite una Categoria: \n");
                categoria = leer.next();
                out.println("Digite Precio: \n");
                precio = leer.nextDouble();
                out.println("Digite el stockMin: \n");
                stockMin = leer.nextInt();
                ((Administrador) adm).create("producto", nombre, categoria, precio, stockMin);
                break;
            case 2:
                Producto producto;
                String campo;
                String nuevoValor;
                out.println("Digite el producto a modificar: ");
                nombre = leer.next();
                producto = ((Administrador) adm).searchProduct(dF.getLstProductos(), nombre);
                if (producto != null) {
                    out.println("Digite el campo a cambiar: \n");
                    campo = leer.next();
                    out.println("Digite el nuevo valor: \n");
                    nuevoValor = leer.next();
                    out.println(producto);
                    out.println(campo);
                    out.println(nuevoValor);
                    ((Administrador) adm).modificarProducto(producto, campo, nuevoValor);
                } else {
                    mantenimientoProducto();
                }
                break;

            case 3:
                Producto producto1;
                String nombreBorrar;
                out.println("Digite el producto a borrar: ");
                nombreBorrar = leer.next();
                producto1 = ((Administrador) adm).searchProduct(dF.getLstProductos(), nombreBorrar);
                if (producto1 != null) {
                    ((Administrador) adm).eliminarProducto(producto1);
                } else {
                    mantenimientoProducto();
                }
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

    /*public static void mantenimientoCategoria() throws IOException {
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
                String nombre;
                out.println("Digite un nombre: \n");
                leer.nextLine();
                nombre = leer.nextLine();

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
    }*/
    public static void mantenimientoClientes() throws IOException {
        Scanner leer = new Scanner(System.in);
        int cod;
        out.println(((Administrador)adm).dF.getLstUsuarios());
        out.println("1. Modificar Cliente\n");
        out.println("2. Eliminar Cliente\n");
        out.println("3. Salir\n");
        out.println("Digite la opcion: ");
        cod = leer.nextInt();
        switch (cod) {

            case 1:
                Usuario cliente;
                String campo;
                String nuevoValor;
                String nombre;
                out.println("Digite el cliente a modificar: ");
                nombre = leer.next();
                cliente = ((Administrador) adm).searchUser(dF.getLstUsuarios(), nombre);
                if (cliente != null) {
                    out.println("Digite el campo a cambiar: \n");
                    campo = leer.next();
                    out.println("Digite el nuevo valor: \n");
                    nuevoValor = leer.next();
                    out.println(cliente);
                    out.println(campo);
                    out.println(nuevoValor);
                    ((Administrador) adm).modificarCliente((Cliente) cliente, campo, nuevoValor);
                }else{
                    mantenimientoClientes();
                }
                break;

            case 2:
                Usuario cliente1;
                String nombreBorrar;
                out.println("Digite el cliente a borrar: ");
                nombreBorrar = leer.next();
                cliente1 = ((Administrador) adm).searchCliente(dF.getLstUsuarios(), nombreBorrar);
                if (cliente1 != null) {
                    ((Administrador) adm).eliminarCliente((Cliente) cliente1);
                } else {
                    mantenimientoProducto();
                }
                break;

            case 3:
                mostrarMenuAdministrador();
                break;
            default:
                out.println("Opcion no valida");
        }
        if (cod != 3) {
            mantenimientoClientes();
        }
    }

    public static void mantenimientoProveedores() throws IOException {
        out.println(((Administrador)adm).dF.getLstProveedores());
        Scanner leer = new Scanner(System.in);
        int cod;
        out.println("1. Agregar Proveedor\n");
        out.println("2. Modificar Proveedor\n");
        out.println("3. Eliminar Proveedor\n");
        out.println("4. Hacer pedido\n");
        out.println("5. Salir\n");
        out.println("Digite la opcion: ");
        cod = leer.nextInt();
        switch (cod) {

            case 1:
                String nombre;
                String correo;
                out.println("Digite un nombre: ");
                nombre = leer.next();
                out.println("Digite una Categoria: \n");
                correo = leer.next();
                ((Administrador) adm).create("proveedor", nombre, correo);
                break;

            case 2:
                break;

            case 3:
                break;
            case 4:
                break;
            case 5:
                mostrarMenuAdministrador();
                break;
            default:
                out.println("Opcion no valida");
        }
        if (cod != 4) {
            mantenimientoProveedores();
        }
    }

    static void mantenimientoCombo() throws IOException {
        Scanner leer = new Scanner(System.in);
        int cod;
        out.println("1. Agregar Proveedor\n");
        out.println("2. Modificar Proveedor\n");
        out.println("3. Eliminar Proveedor\n");
        out.println("4. Hacer pedido\n");
        out.println("5. Salir\n");
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
                break;
            case 5:
                mostrarMenuAdministrador();
                break;
            default:
                out.println("Opcion no valida");
        }
        if (cod != 4) {
            mantenimientoProveedores();
        }
    }

    static void mantenimientoPromociones() throws IOException {
        Scanner leer = new Scanner(System.in);
        int cod;
        out.println("1. Agregar Proveedor\n");
        out.println("2. Modificar Proveedor\n");
        out.println("3. Eliminar Proveedor\n");
        out.println("4. Hacer pedido\n");
        out.println("5. Salir\n");
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
                break;
            case 5:
                mostrarMenuAdministrador();
                break;
            default:
                out.println("Opcion no valida");
        }
        if (cod != 4) {
            mantenimientoPromociones();
        }
    }
//************************************************
//          TERMINA FLUJO DE MENU ADMINISTRADOR
//************************************************

//************************************************
//          INICIA FLUJO DE MENU CLIENTE
//************************************************
    public static void mostrarMenuCliente() throws IOException {
        out.println("Hola Cliente");
        //out.println(df.getLstPromociones());
        out.println(dF.getLstProductos());
        Scanner leer = new Scanner(System.in);
        int cod;
        out.println("1. Lista de Ordenes\n");
        out.println("2. Carrito\n");
        out.println("3. Lista Productos\n");
        out.println("4. Cambio de contraseña\n");
        out.println("5. Salir");
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
                break;
            case 5:
                login();
                break;
        }
    }
}
