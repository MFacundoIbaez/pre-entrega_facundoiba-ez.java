    // subclase de Artículo
public class Articulo {
    private String nombre;
    private double precio;
    private Categoria categoria; // atributo de tipo Categoria

    public Articulo(String nombre, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria; // Inicializa el atributo categoria
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) { // Setter categoría
        this.categoria = categoria;
    }

    public double calcularDescuento() {
        // 10 % de descuento
        return getPrecio() * 0.10;
    }

    @Override
    public String toString() {
       return "Nombre: " + nombre + ", Precio: " + precio + ", Categoria: " + categoria; 
    }   
}
    