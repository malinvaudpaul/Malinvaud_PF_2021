package TD1.ArbresGeneralises;

public class Entier implements Sommable<Entier>, Comparable<Entier> {
    public Integer val;

    public Entier(int val) {
        this.val = val;
    }

    @Override
    public Entier sommer(final Entier s) {
        return new Entier(this.val + s.val);
    }

    @Override
    public int compareTo(Entier other) {
        return this.val.compareTo(other.val);
    }

}
