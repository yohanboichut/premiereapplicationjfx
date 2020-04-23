package fr.youtube.yoh4n.jfx.vues;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Accueil implements Vue{

    private Stage stage;
    private Scene scene;

    private BorderPane borderPane;
    private Button creationPersonne;
    private Button affichagePersonnes;




    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    private Accueil(){

    }
    public static Accueil creer(Stage stage) {
        Accueil accueil = new Accueil();
        accueil.setStage(stage);
        accueil.initialiserComposants();
        return accueil;
    }

    private void initialiserComposants() {

        this.borderPane = new BorderPane();
        this.affichagePersonnes = new Button("Afficher les personnes enregistrées");
        this.creationPersonne = new Button("Enregistrer une nouvelle personne");

        this.affichagePersonnes.setMaxWidth(Double.MAX_VALUE);
        this.creationPersonne.setMaxWidth(Double.MAX_VALUE);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.getChildren().addAll(this.creationPersonne,this.affichagePersonnes);
        this.borderPane.setCenter(vBox);

        Label label = new Label("Menu");
        label.setFont(Font.font(32));
        this.borderPane.setTop(label);

        BorderPane.setAlignment(label, Pos.CENTER);
        BorderPane.setAlignment(vBox,Pos.CENTER);

        this.setScene(new Scene(this.borderPane,600,700));

    }

    @Override
    public void show() {
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
