package COLAS2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vista {
    private Controlador controlador;
    private ListView<String> listaPedidos;

    public Vista() {
        controlador = new Controlador();
        listaPedidos = new ListView<>();
    }

    public VBox getLayout() {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Button btnNuevoPedido = new Button("Nuevo Pedido");
        Button btnAtenderPedido = new Button("Atender Pedido");
        Button btnActualizar = new Button("Actualizar Lista");

        btnNuevoPedido.setOnAction(e -> mostrarFormulario());
        btnAtenderPedido.setOnAction(e -> {
            controlador.atenderPedido();
            actualizarLista();
        });

        btnActualizar.setOnAction(e -> actualizarLista());

        root.getChildren().addAll(btnNuevoPedido, btnAtenderPedido, btnActualizar, listaPedidos);
        actualizarLista();
        return root;
    }

    private void mostrarFormulario() {
        FormularioPedido formulario = new FormularioPedido(controlador, this);
        Stage stage = new Stage();
        stage.setScene(new Scene(formulario.getLayout(), 400, 300));
        stage.setTitle("Nuevo Pedido");
        stage.show();
    }

    public void actualizarLista() {
        listaPedidos.getItems().clear();
        listaPedidos.getItems().addAll(controlador.obtenerListaPedidos());
    }
}
