package TD1.ArbresGeneralises;

import java.util.Set;

public class Feuille<T extends Sommable<T> & Comparable<T>> implements Arbre<T> {
    private final T valeur;

    public Feuille(T valeur) {
        this.valeur = valeur;
    }

    @Override
    public boolean contient(T val) {
        return val.equals(valeur);
    }

    @Override
    public boolean estTrie() {
        return false;
    }

    @Override
    public T max() {
        return valeur;
    }

    @Override
    public T min() {
        return valeur;
    }

    @Override
    public T somme() {
        return valeur;
    }

    @Override
    public int taille() {
        return 1;
    }

    @Override
    public Set<T> valeurs() {
        return Set.of(valeur);
    }
}
