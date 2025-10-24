public class Categoria {
    private int id;
    private String nombre;
private static int contadorIds = 1;
    public Categoria(String nombre) {
        this.nombre = nombre;
        this.id = contadorIds++;
    }public int getId() {
        return id;
    }public String getNombre() {
        return nombre;
    }public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';

      }
}
