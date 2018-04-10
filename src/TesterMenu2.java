
import static java.lang.System.out;
import java.util.InputMismatchException;
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
public class TesterMenu2 {
public static int i = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

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
        out.println(df.getLstUsuarios());
        out.println("Diario Facil");
        menuInicial();

    }

    public static void menuInicial() {
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Login");
            System.out.println("2. Registro");
            System.out.println("3. Salir");

            try {

                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        login();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                leer.next();
            }
        }

    }

    public static void login() {
        DiarioFacil df = new DiarioFacil();
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Como usuario");
            System.out.println("2. Como administrador");
            System.out.println("3. Salir");

            try {

                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        
                        out.println("Contador afuera de la condicion " + i);
                        String nombre;
                        String contraseña;
                        Scanner sn = new Scanner(System.in);
                        out.print("Digite su usuario: \n");
                        nombre = sn.next();
                        out.print("Digite su contraseña: \n");
                        contraseña = sn.next();
                        for (Usuario usuario : df.getLstUsuarios()) {
                            out.print(nombre.equalsIgnoreCase(usuario.getNombre()));
                            if (nombre.equalsIgnoreCase(usuario.getNombre())) {
                                out.println("Contador Antes de llamar Hello World " + i);
                                MenuUsuario();
                                out.println("Contador Despues de llamar Hello World " + i);
                            } else {
                                out.println("Trate de nuevo");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        salir = true;

                        break;
                    default:

                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                leer.next();
            }
        }

    }

    public static void MenuUsuario() {
        out.println("Hola mundo");
    }
}
