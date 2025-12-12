import producto.producto;

public class servicio extends producto {
    private int duracionHoras;//atributo propio de servicio

    public servicio(String nombre, double precio, int duracionHoras) { //constructor super (nombre, precio)
        super(nombre, precio);
        // Constructor de producto
        this.duracionHoras = duracionHoras;
    //setea duracion
    }
    public int getDuracionHoras() {// Getter
        return duracionHoras;
    }
    public void setDuracionHoras(int duracionHoras) {// Setter
        this.duracionHoras = duracionHoras;
    }
    public double calcularDescuento() {
        // 15 % de descuento para servicios
        return getPrecio() * 0.15;
    }
    @Override
    public String toString() {
        return super.toString() + ", DuracionHoras=" + duracionHoras;
    }
    
}