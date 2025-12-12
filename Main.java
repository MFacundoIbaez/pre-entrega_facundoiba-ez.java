import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//
// main (orquestador limpio)
public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        // Crear un nuevo objeto de tipo Producto
        Producto p = new Producto("Laptop", 1500.0);
        // Agregar el producto a la lista
        productos.add(p);

        // Crear categorías
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria("Electrónica"));
        categorias.add(new Categoria("Hogar"));
        categorias.add(new Categoria("Ropa"));
        categorias.add(new Categoria("Deportes"));
        categorias.add(new Categoria("Libros"));
        categorias.add(new Categoria("Juguetes"));
        categorias.add(new Categoria("Salud"));
        categorias.add(new Categoria("Belleza"));
        categorias.add(new Categoria("Automotriz"));
        categorias.add(new Categoria("Alimentos"));
        categorias.add(new Categoria("Bebidas"));
        categorias.add(new Categoria("Muebles"));
        categorias.add(new Categoria("Oficina"));
        categorias.add(new Categoria("Herramientas"));
        categorias.add(new Categoria("Jardinería"));
        categorias.add(new Categoria("Mascotas"));
        categorias.add(new Categoria("Turismo"));
        categorias.add(new Categoria("Tecnología"));
        categorias.add(new Categoria("Fitness"));

        CrudProductos crudpoo = new CrudProductos(productos);
        CrudCategorias crudcat = new CrudCategorias(categorias);

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Gestión de Productos");
            System.out.println("2. Gestión de Categorías");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el salto de línea

            switch (opcion) {
                case 1:
                    crudpoo.mostrarMenu(scanner);
                    break;
                case 2:
                    crudcat.mostrarMenu(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}

// Simple Producto class so the type is defined
class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{nombre='" + nombre + "', precio=" + precio + "}";
    }
}

// Simple Categoria class (ASCII name)
class Categoria {
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

// Minimal CRUD for productos
class CrudProductos {
    private final List<Producto> productos;

    public CrudProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Productos ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private void agregarProducto(Scanner scanner) {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Precio inválido. Intente nuevamente.");
            scanner.next();
        }
        double precio = scanner.nextDouble();
        scanner.nextLine();
        productos.add(new Producto(nombre, precio));
        System.out.println("Producto agregado.");
    }

    private void mostrarProductos() {
        System.out.println("\nProductos registrados:");
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }
}

// Minimal CRUD for categorías
class CrudCategorias {
    private final List<Categoria> categorias;

    public CrudCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Categorías ---");
            System.out.println("1. Mostrar categorías");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    mostrarCategorias();
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private void mostrarCategorias() {
        System.out.println("\nCategorías disponibles:");
        for (Categoria c : categorias) {
            System.out.println("- " + c);
        }
    }
}
