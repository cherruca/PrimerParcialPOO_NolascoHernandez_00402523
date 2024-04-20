import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcion;
        int producto_tipo;
        List<Producto> listado = new ArrayList<Producto>();

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(" ===== BIENVENIDO A ELECTROMART  ===== \n\r1) Agregar producto\n\r2) Modificar producto\n\r3) Consultar listado de productos\n\r4) SALIR\nIngrese una opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("\r=== AGREGAR ===\n\r\rTipo de producto (1 = telefono/2 = laptop): ");
                producto_tipo = sc.nextInt();
                if (producto_tipo == 1) {
                    agregar_telefono(sc, listado);
                } else if (producto_tipo == 2) {
                    System.out.println("LAPTOPPPPP");
                } else {
                    System.out.println(producto_tipo);
                    System.out.println("ERROR: selecciones un tipo de producto válido");
//                    break;
                }
            } else if (opcion == 2) {
                System.out.println("\r=== MODIFICAR (cambiar precio) ===\n\r\r");
            } else if (opcion == 3) {
                System.out.println("\r=== LISTADO DE TODOS LOS PRODUCTOS ===\n\r\r");
                consultar_todos_productos(listado);
            } else if (opcion == 4) {
                System.out.println("\nPrograma finalizado");
            }
        } while (opcion != 4);

    }

    public static void agregar_telefono(Scanner sc, List<Producto> productos) {
        Telefono nuevo_telefono = new Telefono();

        System.out.println("\r\r=== AGREGANDO TELEFONO ===");
        nuevo_telefono.setTipo("telefono");
        System.out.println("Nombre: ");
        nuevo_telefono.setNombre(String.valueOf(sc.next()));
        sc.nextLine();
        System.out.println("Modelo: ");
        nuevo_telefono.setModelo(sc.next());
        sc.nextLine();
        System.out.println("Resolución: ");
        nuevo_telefono.setResolucion(sc.next());
        sc.nextLine();
        System.out.println("Precio: ");
        nuevo_telefono.setPrecio(sc.nextDouble());
        sc.nextLine();
        System.out.println("Plan (por 12 meses): ");
        nuevo_telefono.setPlan_cargo(sc.nextDouble());
        // se suma el precio original del producto más el producto del cargo del plan por 12 meses
        nuevo_telefono.setPrecio(nuevo_telefono.obtener_precio(nuevo_telefono.getPlan_cargo()));
        sc.nextLine();
        // se concatenan los atributos que pertenecen al telefono (resolucion y plan) y se agregan a la descripcion del producto
        StringBuilder sb = new StringBuilder().append("Resolución de ").append(nuevo_telefono.getResolucion()).append("; plan de 12 meses con cargo de $").append(nuevo_telefono.getPlan_cargo()).append(". ");
        nuevo_telefono.setDescripcion(String.valueOf(sb));


        productos.add(nuevo_telefono);
        System.out.println("TELEFONO AGREGADO\nCódigo: " + nuevo_telefono.getCodigo() + "\nNombre: " + nuevo_telefono.getNombre());

    }

    public static void consultar_todos_productos(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println("CÓDIGO: " + producto.getCodigo()
                    + " - NOMBRE: " + producto.getNombre()
                    + " - MODELO: " + producto.getModelo()
                    + " - DESCRIPCION: " + producto.obtener_descripcion(producto.getDescripcion())
                    + " - PRECIO: $" + producto.getPrecio()
                    + "\n---");
        }
    }
}
