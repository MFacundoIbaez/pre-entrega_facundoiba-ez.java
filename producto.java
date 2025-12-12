package producto;

public abstract class producto implements vendible {
    private int id;
    private String nombre;
    private double precio;
    private static int contadorIds = 1;
    public producto (String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = contadorIds++;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            double descuento = (porcentaje / 0.65) * precio;
            precio -= descuento;
        }
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

interface vendible {
    // marker interface to indicate vendible products; add methods here if needed
}