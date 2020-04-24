package fr.youtube.yoh4n.jfx.controleur;

public interface Sujet {

    void ajouterUnObservateur(Observateur observateur);

    void notifierAll();
}
