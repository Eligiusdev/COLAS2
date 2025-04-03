package COLAS2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormularioPedido {
    private Controlador controlador;
    private Vista vista;

    public FormularioPedido(Controlador controlador, Vista vista) {
        this.controlador = controlador;
        this.vista = vista;
    }

    public VBox getLayout() {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        TextField txtCliente = new TextField();
        txtCliente.setPromptText("Nombre del Cliente");

        TextField txtProducto = new TextField();
        txtProducto.setPromptText("Nombre del Producto");

        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");

        TextField txtTiempo = new TextField();
        txtTiempo.setPromptText("Tiempo de Preparación");

        Button btnAgregarProducto = new Button("Agregar Producto");
        Button btnGuardarPedido = new Button("Guardar Pedido");

        ListView<String> listaProductos = new ListView<>();

        Pedido pedido = new Pedido("");

        btnAgregarProducto.setOnAction(e -> {
            String nombre = txtProducto.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int tiempo = Integer.parseInt(txtTiempo.getText());

            Producto producto = new Producto(nombre, precio, tiempo);
            pedido.agregarProducto(producto);
            listaProductos.getItems().add(producto.toString());

            txtProducto.clear();
            txtPrecio.clear();
            txtTiempo.clear();
        });

        btnGuardarPedido.setOnAction(e -> {
            pedido.setCliente(txtCliente.getText());
            controlador.agregarPedido(pedido);
            vista.actualizarLista();
            ((Stage) btnGuardarPedido.getScene().getWindow()).close();
        });

        root.getChildren().addAll(txtCliente, txtProducto, txtPrecio, txtTiempo, btnAgregarProducto, listaProductos, btnGuardarPedido);
        return root;
    }
}

