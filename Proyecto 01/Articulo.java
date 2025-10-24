package crudpoo;    
// subclase de Artículo
public class Articulo {
    private Categoria categoria; atributo de tipo Categoria
    public Articulo(String nombre, double precio, Categoria categoria) {
        super(nombre, precio); // Llama al constructor de la clase base Articulo
        this.categoria = categoria; // Inicializa el atributo categoria
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) { // Setter categoría
        this.categoria = categoria;
    }
    @Override
    public double calcularDescuento() {
         return getPrecio() * 0.10;
         10 % de descuento
        }
    @Override
    public String toString() {
       return super.toString() + ", Categoria: " + categoria; 
    }   
    