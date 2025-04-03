package COLAS2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.stream.Collectors;

public class MetodosPedidos {
    private Queue<Pedido> pedidos;

    public MetodosPedidos() {
        pedidos = new LinkedList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.offer(pedido);
    }

    public void atenderPedido() {
        if (!pedidos.isEmpty()) {
            pedidos.poll();
        }
    }

    public List<String> obtenerListaPedidos() {
        return pedidos.stream().map(Pedido::toString).collect(Collectors.toList());
    }
}
