package TD1.ArbresSimples;

import java.util.Set;

public class Feuille implements Arbre {
    private final Integer valeur;

    public Feuille(Integer valeur) {
        this.valeur = valeur;
    }

    @Override
    public boolean contient(Integer val) {
        return val.equals(valeur);
    }

    @Override
    public boolean estTrie() {
        return false;
    }

    @Override
    public Integer max() {
        return valeur;
    }

    @Override
    public Integer min() {
        return valeur;
    }

    @Override
    public Integer somme() {
        return valeur;
    }

    @Override
    public int taille() {
        return 1;
    }

    @Override
    public Set<Integer> valeurs() {
        return Set.of(valeur);
    }

}
