package fr.youtube.yoh4n.jfx;


import fr.youtube.yoh4n.jfx.controleur.Controleur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Controleur controleur = new Controleur(stage);
        controleur.run();

    }


    public static void main(String[] args) {
        launch();
    }

}