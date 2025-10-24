package inicio;
import java.util.ArrayList;
import java.util.Scanner;

// Definición de la clase Categoría
class Categoría {
    private int id;
    private String nombre;

    public Categoría(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

// Definición de la clase Artículo
class Artículo {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private String descripción;
    private double precio;
    private Categoría categoría;

    public Artículo(String nombre, String descripción, double precio, Categoría categoría) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.descripción = descripción;
        this.precio = precio;
        this.categoría = categoría;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoría getCategoría() {
        return categoría;
    }

    public void setCategoría(Categoría categoría) {
        this.categoría = categoría;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Descripción: " + descripción +
               ", Precio: " + precio + ", Categoría: " + categoría.getNombre();
    }
}

class Main {
    private static ArrayList<Artículo> artículos = new ArrayList<>();
    private static ArrayList<Categoría> categorías = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static {
        categorías.add(new Categoría(1, "Tecnología"));
        categorías.add(new Categoría(2, "Hogar"));
        categorías.add(new Categoría(3, "Libros"));
        categorías.add(new Categoría(4, "Ropa"));
        categorías.add(new Categoría(5, "Vehículos"));
        categorías.add(new Categoría(6, "Inmuebles"));
        categorías.add(new Categoría(7, "Deportes"));
        categorías.add(new Categoría(8, "Salud"));
        categorías.add(new Categoría(9, "Alimentos"));
        categorías.add(new Categoría(10, "Juguetes"));
        categorías.add(new Categoría(11, "Música"));
        categorías.add(new Categoría(13, "Jardinería"));
        categorías.add(new Categoría(14, "Oficina"));
    }

    private static void eliminarArtículo() {
        System.out.print("Ingrese el ID del artículo a eliminar: ");
        int id = scanner.nextInt();
        Artículo artículoAEliminar = null;
        for (Artículo artículo : artículos) {
            if (artículo.getId() == id) {
                artículoAEliminar = artículo;
                break;
            }
        }
        if (artículoAEliminar != null) {
            artículos.remove(artículoAEliminar);
            System.out.println("Artículo eliminado exitosamente.");
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }
    private static void actualizarArtículo() {
        System.out.print("Ingrese el ID del artículo a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        Artículo artículoAActualizar = null;
        for (Artículo artículo : artículos) {
            if (artículo.getId() == id) {
                artículoAActualizar = artículo;
                break;
            }
        }
        if (artículoAActualizar != null) {
            System.out.print("Ingrese el nuevo nombre del artículo: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese la nueva descripción del artículo: ");
            String nuevaDescripción = scanner.nextLine();
            System.out.print("Ingrese el nuevo precio del artículo: ");
            double nuevoPrecio = scanner.nextDouble();
            artículoAActualizar.setNombre(nuevoNombre);
            artículoAActualizar.setDescripción(nuevaDescripción);
            artículoAActualizar.setPrecio(nuevoPrecio);
            System.out.println("Artículo actualizado exitosamente.");
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }
    private static void buscarArtículos() {
        if (artículos.isEmpty()) {
            System.out.println("No hay artículos disponibles.");
        } else {
            for (Artículo artículo : artículos) {
                System.out.println(artículo);
            }
        }
    }
    private static void crearArtículo() {
        System.out.print("Ingrese el nombre del artículo: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del artículo: ");
        String descripción = scanner.nextLine();
        System.out.print("Ingrese el precio del artículo: ");
        double precio = scanner.nextDouble();
        System.out.println("Seleccione una categoría:");
        for (Categoría categoría : categorías) {
            System.out.println(categoría.getId() + ". " + categoría.getNombre());
        }
        int categoríaId = scanner.nextInt();
        Categoría categoríaSeleccionada = null;
        for (Categoría categoría : categorías) {
            if (categoría.getId() == categoríaId) {
                categoríaSeleccionada = categoría;
                break;
            }
        }
        if (categoríaSeleccionada != null) {
            Artículo nuevoArtículo = new Artículo(nombre, descripción, precio, categoríaSeleccionada);
            artículos.add(nuevoArtículo);
            System.out.println("Artículo creado exitosamente.");
        } else {
            System.out.println("Categoría no válida.");
        }
    }

    public static void main(String[] args) {
        int opción;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Crear artículo");
            System.out.println("2. Leer artículos");
            System.out.println("3. Actualizar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opción = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opción) {
                case 1:
                    crearArtículo();
                    break;
                case 2:
                    buscarArtículos();
                    break;
                case 3:
                    actualizarArtículo();
                    break;
                case 4:
                    eliminarArtículo();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opción != 5);
        scanner.close();
    }
}