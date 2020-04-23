package fr.youtube.yoh4n.jfx.modele;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FacadeImpl implements Facade {


    private Map<Long, Personne> personnes;


    public FacadeImpl() {
        this.personnes = new HashMap<>();
    }


    @Override
    public long creerPersonne(String nom, String prenom, String login, String password) {
        Personne personne = Personne.creer(nom,prenom,login,password);
        this.personnes.put(personne.getId(),personne);
        return personne.getId();
    }

    @Override
    public Personne getPersonneById(long id) throws PersonneNotFoundException {

        if (this.personnes.containsKey(id)) {
            return this.personnes.get(id);
        }
        else {
            throw new PersonneNotFoundException();
        }
    }

    @Override
    public Collection<Personne> getAllPersonnes() {
        return this.personnes.values();
    }
}
