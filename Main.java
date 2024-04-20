import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcion, producto_tipo, consulta_numero;
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
                    agregar_laptop(sc, listado);
                } else {
                    System.out.println(producto_tipo);
                    System.out.println("ERROR: selecciones un tipo de producto válido");
//                    break;
                }
            } else if (opcion == 2) {
                System.out.println("\r=== MODIFICAR (cambiar precio) ===\n\r\r");
                System.out.println("Ingrese código de producto a modificar: ");
                consulta_numero = sc.nextInt();
                sc.nextLine();
                if (buscar_producto(consulta_numero, listado) != null) {
                    System.out.println("Modificando producto No. " + buscar_producto(consulta_numero, listado).getCodigo());
                    System.out.println("Ingrese nuevo precio: ");
                    buscar_producto(consulta_numero, listado).setPrecio(sc.nextDouble());
                    System.out.println("PRECIO MODIFICADO");
                } else {
                    System.out.println("ERROR: producto no encontrado");
                }
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
        System.out.println("TELEFONO AGREGADO\nCódigo: " + nuevo_telefono.getCodigo() + "\nNombre: " + nuevo_telefono.getNombre() + "\nPrecio (con cargo de plan por 12 meses): $" + nuevo_telefono.getPrecio());

    }

    public static void agregar_laptop(Scanner sc, List<Producto> productos) {
        Laptop nueva_laptop = new Laptop();

        System.out.println("\r\r=== AGREGANDO LAPTOP ===");
        nueva_laptop.setTipo("laptop");
        System.out.println("Nombre: ");
        nueva_laptop.setNombre(String.valueOf(sc.next()));
        sc.nextLine();
        System.out.println("Modelo: ");
        nueva_laptop.setModelo(sc.next());
        sc.nextLine();
        System.out.println("Procesador: ");
        nueva_laptop.setProcesador(sc.next());
        sc.nextLine();
        System.out.println("Precio: ");
        nueva_laptop.setPrecio(sc.nextDouble());
        sc.nextLine();
        // NO se suma algo al precio original del producto
//        nueva_laptop.setPrecio(nueva_laptop.obtener_precio(0));
        // se concatenan los atributos que pertenecen a la laptop (procesador) y se agregan a la descripcion del producto
        StringBuilder sb = new StringBuilder().append("Procesador ").append(nueva_laptop.getProcesador()).append(". ");
        nueva_laptop.setDescripcion(String.valueOf(sb));


        productos.add(nueva_laptop);
        System.out.println("LAPTOP AGREGADA\nCódigo: " + nueva_laptop.getCodigo() + "\nNombre: " + nueva_laptop.getNombre() + "\nPrecio: $" + nueva_laptop.getPrecio());

    }

    public static void consultar_todos_productos(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println("CÓDIGO: " + producto.getCodigo()
                    + " - TIPO: " + producto.getTipo()
                    + " - NOMBRE: " + producto.getNombre()
                    + " - MODELO: " + producto.getModelo()
                    + " - DESCRIPCION: " + producto.obtener_descripcion(producto.getDescripcion())
                    + " - PRECIO: $" + producto.getPrecio()
                    + "\n---");
        }
    }



    public static Producto buscar_producto(int consulta_numero, List<Producto> productos) {
        for(Producto producto : productos) {
            if(producto.getCodigo() == consulta_numero) {
                return producto;
            }
        }
        return null;
    }
}
