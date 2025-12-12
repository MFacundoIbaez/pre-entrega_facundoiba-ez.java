import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class crudCategorias {
    private final ArrayList<Categoria> categorias;
    private static final Scanner SC = new Scanner(System.in);

    public crudCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void crear () {
        String nombre = leerTexto("Nombre de la nueva categoría:");
        categorias.add(new Categoria(nombre));
        System.out.println("Categoría creada.");
    }

    public void listar() {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías registradas.");
        } else {
            System.out.println("Categorías registradas:");
            for (Categoria c : categorias) {
                System.out.println(c);
            }
        }
    }

    public void actualizar() {
        int id = leerEntero("ID de la categoría:");
        for (Categoria c : categorias) {
            if (c.getId() == id) {
                String nuevo = leerTexto("Nuevo nombre:");
                c.setNombre(nuevo);
                System.out.println("actualizada: " + c);
                return;
            }
        }
        System.out.println("Categoría con ID " + id + " no encontrada.");
    }

    public void eliminar() {
        int id = leerEntero("ID de la categoría a eliminar:");
        Iterator<Categoria> iterator = categorias.iterator();
        while (iterator.hasNext()) {
            Categoria c = iterator.next();
            if (c.getId() == id) {
                iterator.remove();
                System.out.println("Categoría eliminada.");
                return;
            }
        }
        System.out.println("Categoría con ID " + id + " no encontrada.");
    }

    // Simple console helpers to replace functionality from the missing CrudConsola base
    private String leerTexto(String prompt) {
        System.out.print(prompt + " ");
        return SC.nextLine();
    }

    private int leerEntero(String prompt) {
        System.out.print(prompt + " ");
        while (true) {
            String line = SC.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }
}