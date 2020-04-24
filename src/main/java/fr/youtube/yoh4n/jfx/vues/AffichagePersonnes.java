package fr.youtube.yoh4n.jfx.vues;

import fr.youtube.yoh4n.jfx.controleur.Controleur;
import fr.youtube.yoh4n.jfx.controleur.Observateur;
import fr.youtube.yoh4n.jfx.modele.Personne;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Objects;

public class AffichagePersonnes implements Vue, Observateur {

    private Stage stage;
    private Scene scene;

    private Controleur controleur;


    @FXML
    ListView<Personne> listePersonnes;

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }


    public static AffichagePersonnes creer(Stage stage,Controleur controleur) {
        URL location = AffichagePersonnes.class.getResource("affichagePersonnes.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);

        try {
            BorderPane borderPane = fxmlLoader.load();

            AffichagePersonnes vue = fxmlLoader.getController();
            vue.setStage(stage);
            vue.setControleur(controleur);
            controleur.ajouterUnObservateur(vue);
            vue.setScene(new Scene(borderPane,600,700));
            vue.costumiserListView();
            return vue;

        } catch (IOException e) {
            throw new RuntimeException("Problème FXML : affichagePersonnes.fxml");
        }
    }



    private void costumiserListView(){
        this.listePersonnes.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Personne> call(ListView<Personne> personneListView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Personne personne, boolean b) {
                        if (!Objects.isNull(personne)) {
                            this.setText(personne.getId() + " - " + personne.getPseudo());
                        }
                    }
                };
            }
        });
    }

    @Override
    public void show() {
        this.stage.setScene(this.scene);
        this.stage.show();

    }

    public void menu(ActionEvent actionEvent) {
        this.controleur.run();
    }

    @Override
    public void notifier() {
        Collection<Personne> personnes = this.controleur.getPersonnes();
        this.listePersonnes.getItems().clear();
        this.listePersonnes.refresh();
        this.listePersonnes.setItems(FXCollections.observableArrayList(personnes));
        this.listePersonnes.refresh();
    }
}
