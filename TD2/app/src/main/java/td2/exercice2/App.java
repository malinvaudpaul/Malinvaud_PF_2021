package td2.exercice2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App<T> {
    Predicate<Paire<Integer, Double>> tropPetite = p -> p.fst < 100;
    Predicate<Paire<Integer, Double>> tropGrande = p -> p.fst > 200;
    Predicate<Paire<Integer, Double>> tailleIncorrecte = p -> tropPetite.test(p) || tropGrande.test(p);
    Predicate<Paire<Integer, Double>> tailleCorrecte = Predicate.not(tailleIncorrecte);
    Predicate<Paire<Integer, Double>> tropLourd = p -> p.snd > 150.0;
    Predicate<Paire<Integer, Double>> poidsCorrect = Predicate.not(tropLourd);
    Predicate<Paire<Integer, Double>> accesAutorise = p -> tailleCorrecte.test(p) && poidsCorrect.test(p);

    public <T> List<T> filtragePredicatif(List<Predicate<T>> conditions, List<T> elements){
        List<T> rtn = new ArrayList<>();
        //On récupère les prédicats
        Predicate<T> predicat = x -> true;

        for(Predicate<T> p : conditions){
            predicat = predicat.and(p);
        }
        for(T e : elements) {
            if (predicat.test(e)){
                rtn.add(e);
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        App app = new App<>();

        Paire bobYes = new Paire(150, 100.0); // taille: 150, poids: 100.0 -> ok
        Paire bobNo = new Paire(250, 100.0); // taille: 250, poids: 100.0 -> trop Grand
        Paire bobFat = new Paire(150, 200.0); // taille: 150, poids: 200.0 -> trop Lourd

        System.out.println(app.accesAutorise.test(bobYes));
        System.out.println(app.accesAutorise.test(bobNo));
        System.out.println(app.accesAutorise.test(bobFat));

    }
}
