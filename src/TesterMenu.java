
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
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        DiarioFacil df = new DiarioFacil();

        Usuario cliente1 = new Cliente();
        cliente1.setCedula("12345678");
        cliente1.setNombre("Mateo Marin");
        cliente1.setTelefono("84863651");
        cliente1.setContraseña("vaca94");

        Usuario cliente2 = new Cliente();
        cliente2.setCedula("117580729");
        cliente2.setNombre("Luis Fernandez");
        cliente2.setTelefono("83730387");
        cliente2.setContraseña("reloj123");

        Usuario cliente3 = new Cliente();
        cliente3.setCedula("115689435");
        cliente3.setNombre("Antonio Alvarez");
        cliente3.setTelefono("88987432");
        cliente3.setContraseña("gallina23");

        Usuario administrador1 = new Administrador();
        administrador1.setNombre("Jaime");
        administrador1.setCedula("123456789");
        administrador1.setTelefono("22253625");
        administrador1.setContraseña("chirulo76");

        Usuario administrador2 = new Administrador();
        administrador1.setNombre("Pedro");
        administrador1.setCedula("987654321");
        administrador1.setTelefono("88988754");
        administrador1.setContraseña("pedro123");

        df.agregarUsuario(cliente1);
        df.agregarUsuario(cliente2);
        df.agregarUsuario(cliente3);
        df.agregarUsuario(administrador1);
        df.agregarUsuario(administrador2);

        out.println("Diario Facil");
        int opc;
        boolean salir;

        do {
            mostrarMenu();
            opc = leerOpcion();
            salir = ejecutarAccion(opc);
        } while(!salir);
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

        boolean salir = false;
        int numProd = 0;

        switch (popcion) {

            case 1: //Opcion Agregar Producto

                login();
                break;

            case 2:// Modificar Producto

                out.println();
                registro();
                break;
            case 3://Salir
                out.println("Gracias por usar Diario Facil");
                salir = true;
                break;

            default: //Cualquier otro valor dado por el usuario se considera inválido

                out.println("Opcion inválida");
                out.println();
                break;
        }
        return salir;
    }

    public static void login() throws IOException {
        DiarioFacil df = new DiarioFacil();

        Usuario cliente1 = new Cliente();
        cliente1.setCedula("12345678");
        cliente1.setNombre("Mateo Marin");
        cliente1.setTelefono("84863651");
        cliente1.setContraseña("vaca94");

        Usuario cliente2 = new Cliente();
        cliente2.setCedula("117580729");
        cliente2.setNombre("Luis Fernandez");
        cliente2.setTelefono("83730387");
        cliente2.setContraseña("reloj123");

        Usuario cliente3 = new Cliente();
        cliente3.setCedula("115689435");
        cliente3.setNombre("Antonio Alvarez");
        cliente3.setTelefono("88987432");
        cliente3.setContraseña("gallina23");

        Usuario administrador1 = new Administrador();
        administrador1.setNombre("Jaime");
        administrador1.setCedula("123456789");
        administrador1.setTelefono("22253625");
        administrador1.setContraseña("chirulo76");

        Usuario administrador2 = new Administrador();
        administrador1.setNombre("Pedro");
        administrador1.setCedula("987654321");
        administrador1.setTelefono("88988754");
        administrador1.setContraseña("pedro123");

        df.agregarUsuario(cliente1);
        df.agregarUsuario(cliente2);
        df.agregarUsuario(cliente3);
        df.agregarUsuario(administrador1);
        df.agregarUsuario(administrador2);
        Scanner leer = new Scanner(System.in);
        int cod;
        out.println("1. Como administrador\n");
        out.println("2. Como usuario\n");
        out.println("Digite la opcion: \n");
        cod = leer.nextInt();
        out.println(df.getLstUsuarios());
        switch (cod) {
            case 1:
                out.println("Digite su usuario de administrador : \n");
                String user = in.readLine();
                out.println("Digite su pass: \n");
                String pass = in.readLine();
                for (Usuario usuario : df.getLstUsuarios()) {
                    if (user.equals(usuario.getNombre()) && pass.equals(usuario.getContraseña())) {
                        mostrarMenuAdministrador();
                    }
                }
                break;
        }
    }



    public static void registro() throws IOException {
        out.println("Digite un nombre : ");

    }

    public static void mostrarMenuAdministrador() {
        out.println("Hola administrador");
    }

}
