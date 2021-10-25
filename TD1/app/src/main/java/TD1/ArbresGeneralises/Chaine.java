package TD1.ArbresGeneralises;

public class Chaine implements Sommable<Chaine>, Comparable<Chaine> {
    public String val;

    public Chaine(String val) {
        this.val = val;
    }

    @Override
    public Chaine sommer(final Chaine s) {
        return new Chaine(this.val.concat(s.val));
    }

    @Override
    public int compareTo(Chaine other) {
        return this.val.compareTo(other.val);
    }

}
