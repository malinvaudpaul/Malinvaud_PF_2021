package td3.exercice1.arbresgeneriques2;

public interface Sommable<T> {
    T sommer(final T autre);
    T zero();
}