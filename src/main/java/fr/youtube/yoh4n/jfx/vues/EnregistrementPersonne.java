package fr.youtube.yoh4n.jfx.vues;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class EnregistrementPersonne implements Vue {

    private Stage stage;
    private Scene scene;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }


    public static EnregistrementPersonne creer(Stage stage) {
        URL location = EnregistrementPersonne.class.getResource("enregistrementPersonne.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);

        try {
            BorderPane borderPane = fxmlLoader.load();

            EnregistrementPersonne vue = fxmlLoader.getController();
            vue.setStage(stage);
            vue.setScene(new Scene(borderPane,600,700));
            return vue;

        } catch (IOException e) {
            throw new RuntimeException("Problème FXML : enregistrementPersonne.fxml");
        }
    }


    @Override
    public void show() {
        this.stage.setScene(this.scene);
        this.stage.show();

    }
}
