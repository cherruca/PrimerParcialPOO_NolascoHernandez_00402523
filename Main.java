import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion, producto_tipo;
        List<Producto> listado = new ArrayList<Producto>();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(" ===== BIENVENIDO A ELECTROMART  ===== \n\r1) Agregar producto\n\r2) Modificar producto\n\r3) Consultar listado de productos\n\r4) SALIR\nIngrese una opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("\r=== AGREGAR ===\n\r\rTipo de producto (telefono/laptop): ");
            } else if (opcion == 2) {
                System.out.println("\r=== MODIFICAR ===\n\r\r");
            } else if (opcion == 3) {
                System.out.println("\r=== LISTADO DE TODOS LOS PRODUCTOS ===\n\r\r");
            } else if (opcion == 4) {
                System.out.println("\nPrograma finalizado");
            }
        } while (opcion != 4);

    }
}
