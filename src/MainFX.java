import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MainFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega a aparência a partir do ficheiro FXML
        Parent root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));

        primaryStage.setTitle("Sistema de Chamados");
        primaryStage.setScene(new Scene(root, 800, 600)); // Define o tamanho da janela
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}