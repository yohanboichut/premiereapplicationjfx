package fr.youtube.yoh4n.jfx;


import fr.youtube.yoh4n.jfx.vues.Accueil;
import fr.youtube.yoh4n.jfx.vues.AffichagePersonnes;
import fr.youtube.yoh4n.jfx.vues.EnregistrementPersonne;
import fr.youtube.yoh4n.jfx.vues.Vue;
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
        Vue accueil = Accueil.creer(stage);
        accueil.show();

        Vue enregistrementPersonne = EnregistrementPersonne.creer(stage);
        enregistrementPersonne.show();

        Vue affichagePersonnes = AffichagePersonnes.creer(stage);
        affichagePersonnes.show();

    }


    public static void main(String[] args) {
        launch();
    }

}