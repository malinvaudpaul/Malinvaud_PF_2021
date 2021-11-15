package td3.exercice2;

@FunctionalInterface
public interface ToString<T> {
    String convert(T source);
}
