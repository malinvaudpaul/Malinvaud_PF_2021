package td2.exercice2;

import java.util.function.Function;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        Predicate<Paire<Integer, Double>> tropPetite = p -> p.fst < 100;
        Predicate<Paire<Integer, Double>> tropGrande = p -> p.fst > 200;
        Predicate<Paire<Integer, Double>> tailleIncorrecte = p -> tropPetite.test(p) || tropGrande.test(p);
        Predicate<Paire<Integer, Double>> tailleCorrecte = Predicate.not(tailleIncorrecte);
        Predicate<Paire<Integer, Double>> tropLourd = p -> p.snd > 150.0;
        Predicate<Paire<Integer, Double>> poidsCorrect = Predicate.not(tropLourd);
        Predicate<Paire<Integer, Double>> accesAutorise = p -> tailleCorrecte.test(p) && poidsCorrect.test(p);

        Paire bobYes = new Paire(150, 100.0); // taille: 150, poids: 100.0 -> ok
        Paire bobNo = new Paire(250, 100.0); // taille: 250, poids: 100.0 -> trop Grand
        Paire bobFat = new Paire(150, 200.0); // taille: 150, poids: 200.0 -> trop Lourd

        System.out.println(accesAutorise.test(bobYes));
        System.out.println(accesAutorise.test(bobNo));
        System.out.println(accesAutorise.test(bobFat));

    }
}
