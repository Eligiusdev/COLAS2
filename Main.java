package COLAS2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Vista vista = new Vista();
        Scene scene = new Scene(vista.getLayout(), 600, 400);

        primaryStage.setTitle("Sistema de Pedidos - Comida Rápida");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
