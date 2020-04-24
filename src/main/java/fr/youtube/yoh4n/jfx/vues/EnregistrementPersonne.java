package fr.youtube.yoh4n.jfx.vues;

import fr.youtube.yoh4n.jfx.controleur.Controleur;
import fr.youtube.yoh4n.jfx.modele.Personne;
import fr.youtube.yoh4n.jfx.modele.PersonneNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class EnregistrementPersonne implements Vue {

    private Stage stage;
    private Scene scene;
    private Controleur controleur;


    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField pseudo;

    @FXML
    private PasswordField password;


    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }


    public static EnregistrementPersonne creer(Stage stage,Controleur controleur) {
        URL location = EnregistrementPersonne.class.getResource("enregistrementPersonne.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);

        try {
            BorderPane borderPane = fxmlLoader.load();

            EnregistrementPersonne vue = fxmlLoader.getController();
            vue.setStage(stage);
            vue.setControleur(controleur);
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


    public void resetFields(ActionEvent actionEvent) {
        this.nom.setText("");
        this.prenom.setText("");
        this.pseudo.setText("");
        this.password.setText("");
    }

    private void erreur(String message,String titre){
        Alert alert = new Alert(Alert.AlertType.ERROR,message, ButtonType.OK);
        alert.setTitle(titre);
        alert.showAndWait();

    }


    public void enregistrerPersonne(ActionEvent actionEvent) {

        String nomText = this.nom.getText();
        String prenomText = this.prenom.getText();
        String pseudoText = this.pseudo.getText();
        String passwordText = this.password.getText();

        if (nomText.length() > 0 && prenomText.length() > 0 && pseudoText.length() > 0 && passwordText.length() > 0) {
            try {
                Personne personne = this.controleur.enregistrerUnePersonne(nomText,prenomText,pseudoText,passwordText);
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"La personne avec le pseudo "+personne.getPseudo()
                        + " a bien été créée sous l'identifiant "+personne.getId(), ButtonType.OK);
                alert.showAndWait();

            } catch (PersonneNotFoundException e) {
                this.erreur("L'enregistrement' s'est mal passé","Erreur d'enregistrement");
            }

        }

        else {
            this.erreur("Toutes les informations sont obligatoires","Erreur de saisie");
        }

    }

    public void menu(ActionEvent actionEvent) {
        this.controleur.run();
    }
}
