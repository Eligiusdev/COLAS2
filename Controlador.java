package COLAS2;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private MetodosPedidos metodos;

    public Controlador() {
        metodos = new MetodosPedidos();
    }

    public void agregarPedido(Pedido pedido) {
        metodos.agregarPedido(pedido);
    }

    public void atenderPedido() {
        metodos.atenderPedido();
    }

    public List<String> obtenerListaPedidos() {
        return metodos.obtenerListaPedidos();
    }
}


