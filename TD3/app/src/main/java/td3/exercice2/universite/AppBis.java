package td3.exercice2.universite;

import td3.exercice2.App;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static td3.exercice2.App.aDEF;

public class AppBis {
    // matières d'une année
    public static final Function<Annee, Stream<Matiere>> matieresA =
            a -> a.ues().stream().flatMap(e -> e.ects().keySet().stream());

    // matières d'un étudiant
    public static final Function<Etudiant, Stream<Matiere>> matieresE =
            e -> e.notes().keySet().stream();

    // matières coefficientées d'un étudiant (version Entry)
    public static final Function<Etudiant, Stream<Map.Entry<Matiere, Integer>>> matieresCoefE_ =
            e -> e.annee().ues().stream().flatMap(f -> f.ects().entrySet().stream());

    // transformation d'une Entry en une Paire
    public static final Function<Map.Entry<Matiere, Integer>, App.Paire<Matiere, Integer>> entry2paire =
            e -> new App.Paire<>(e.getKey(), e.getValue());

    // matières coefficientées d'un étudiant (version Paire)
    public static final Function<Etudiant, Stream<App.Paire<Matiere, Integer>>> matieresCoefE =
            e -> matieresCoefE_.apply(e).map(entry2paire);

    // accumulateur pour calcul de la moyenne
    // ((asomme, acoefs), (note, coef)) -> (asomme+note*coef, acoef+coef)
    public static final BinaryOperator<App.Paire<Double, Integer>> accumulateurMoyenne =
            (a, b) -> new App.Paire<>(a.fst + b.fst * b.snd, a.snd+ b.snd);

    // zero (valeur initiale pour l'accumulateur)
    public static final App.Paire<Double, Integer> zero = new App.Paire<>(0.0,0);

    // obtention de la liste de (note, coef) pour les matières d'un étudiant
    // 1. obtenir les (matière, coef)s
    // 2. mapper pour obtenir les (note, coef)s, null pour la note si l'étudiant est DEF dans cette matière
    public static final Function<Etudiant, List<App.Paire<Double, Integer>>> notesPonderees =
            e -> matieresCoefE.apply(e).map(p -> new App.Paire<>(e.notes().get(p.fst),p.snd)).collect(Collectors.toList());

    // obtention de la liste de (note, coef) pour les matières d'un étudiant
    // 1. obtenir les (matière, coef)s
    // 2. mapper pour obtenir les (note, coef)s, 0.0 pour la note si l'étudiant est DEF dans cette matière
    public static final Function<Etudiant, List<App.Paire<Double, Integer>>> notesPondereesIndicatives =
            l -> matieresCoefE.apply(l)
                    .map(p-> {
                        if (p.fst != null) return new App.Paire<>(l.notes().get(p.fst), p.snd);
                        else return new App.Paire<>(0.0, p.snd);
                    }).collect(Collectors.toList());

    // replie avec l'accumulateur spécifique
    public static final Function<List<App.Paire<Double, Integer>>, App.Paire<Double, Integer>> reduit =
            l -> l.stream().reduce(zero,accumulateurMoyenne);

    // calcule la moyenne à partir d'un couple (somme pondérée, somme coefs)
    public static final Function<App.Paire<Double, Integer>, Double> divise =
            p -> p.fst/ p.snd;

    // calcul de moyenne fonctionnel
    // composer notesPonderees, reduit et divise
    // exception en cas de matière DEF
    public static final Function<Etudiant, Double> computeMoyenne =
            e -> notesPonderees.andThen(reduit).andThen(divise).apply(e);

    // calcul de moyenne fonctionnel
    // composer notesPondereesIndicatives, reduit et divise
    // pas d'exception en cas de matière DEF
    public static final Function<Etudiant, Double> computeMoyenneIndicative =
            e -> notesPondereesIndicatives.andThen(reduit).andThen(divise).apply(e);

    // calcul de moyenne
    public static final Function<Etudiant, Double> moyenne = e -> (e == null || aDEF.test(e)) ? null : computeMoyenne.apply(e);

    // calcul de moyenne indicative
    public static final Function<Etudiant, Double> moyenneIndicative =
            computeMoyenneIndicative;

    public static void main(String[] args) {
    }
}
