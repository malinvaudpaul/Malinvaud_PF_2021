package td2.exercice2;

import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        Predicate<Paire<Integer, Double>> tropPetite = p -> p.fst < 100;
        Predicate<Paire<Integer, Double>> tropGrande = p -> p.fst > 200;
        Predicate<Paire<Integer, Double>> tailleIncorrecte = p -> tropPetite.test(p) || tropGrande.test(p);
        Predicate<Paire<Integer, Double>> tailleCorrecte = Predicate.not(tailleIncorrecte);
        Predicate<Paire<Integer, Double>> tropLourd = p -> p.snd > 150.0;
        Predicate<Paire<Integer, Double>> poidsCorrect = Predicate.not(tropLourd);
        Predicate<Paire<Integer, Double>> accèsAutorisé = p -> tailleCorrecte.test(p) && poidsCorrect.test(p);
    }
}
