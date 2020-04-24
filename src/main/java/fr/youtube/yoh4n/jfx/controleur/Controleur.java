package fr.youtube.yoh4n.jfx.controleur;

import fr.youtube.yoh4n.jfx.modele.Facade;
import fr.youtube.yoh4n.jfx.modele.FacadeImpl;
import fr.youtube.yoh4n.jfx.modele.Personne;
import fr.youtube.yoh4n.jfx.modele.PersonneNotFoundException;
import fr.youtube.yoh4n.jfx.vues.Accueil;
import fr.youtube.yoh4n.jfx.vues.AffichagePersonnes;
import fr.youtube.yoh4n.jfx.vues.EnregistrementPersonne;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;

public class Controleur implements Sujet{


    private Facade facade;
    private Accueil accueil;
    private AffichagePersonnes affichagePersonnes;
    private EnregistrementPersonne enregistrementPersonne;

    private Collection<Observateur> observateurs;

    public Controleur(Stage stage) {
        this.facade = new FacadeImpl();
        this.observateurs = new ArrayList<>();
        this.initialiserVue(stage);
    }


    private void initialiserVue(Stage stage){
        this.accueil = Accueil.creer(stage,this);
        this.enregistrementPersonne = EnregistrementPersonne.creer(stage,this);
        this.affichagePersonnes = AffichagePersonnes.creer(stage,this);
    }

    public void run() {
        accueil.show();
    }

    public void gotoAffichagePersonnes() {
        this.affichagePersonnes.show();


    }

    public void gotoEnregistrementPersonne() {
        this.enregistrementPersonne.show();
    }

    public Personne enregistrerUnePersonne(String nomText, String prenomText, String pseudoText, String passwordText) throws PersonneNotFoundException {
        long id = this.facade.creerPersonne(nomText, prenomText, pseudoText, passwordText);
        this.notifierAll();
        Personne personneCreee = this.facade.getPersonneById(id);
        return personneCreee;
    }

    @Override
    public void ajouterUnObservateur(Observateur observateur) {
        this.observateurs.add(observateur);
    }

    @Override
    public void notifierAll() {
        this.observateurs.stream().forEach( e -> e.notifier());
    }

    public Collection<Personne> getPersonnes() {
        return this.facade.getAllPersonnes();
    }
}
