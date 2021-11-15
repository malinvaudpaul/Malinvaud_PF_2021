package td3.exercice1.arbresgeneriques2;

import java.util.Set;

import td3.exercice1.arbresgeneriques2.Sommable;

public class Feuille<T extends Sommable<T> & Comparable<T>> implements Arbre<T> {

    private final T valeur;

    public Feuille(final T valeur) {
        this.valeur = valeur;
    }

    @Override
    public int taille() {
        return 1;
    }

    @Override
    public boolean contient(final T val) {
        return val.equals(valeur);
    }

    @Override
    public Set<T> valeurs() {
        return Set.of(valeur);
    }

    @Override
    public T somme() {
        return valeur;
    }

    @Override
    public T min() {
        return valeur;
    }

    @Override
    public T max() {
        return valeur;
    }

    @Override
    public boolean estTrie() {
        return true;
    }

}