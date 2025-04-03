package COLAS2;
import java.util.Stack;

public class Pedido {
    private String cliente;
    private Stack<Producto> productos;
    private int tiempoEstimado;

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.productos = new Stack<>();
        this.tiempoEstimado = 0;
    }

    public void agregarProducto(Producto producto) {
        productos.push(producto);
        tiempoEstimado += producto.getTiempoPreparacion();
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido de " + cliente + " - Productos: " + productos.size() + " - Total: $" + calcularTotal();
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}

