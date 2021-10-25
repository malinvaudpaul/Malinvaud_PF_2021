package TD1.Paires;

public class Paire<A, B> implements IPaire<A, B> {
    private A _fst;
    private B _snd;

    @Override
    public A fst() {
        return _fst;
    }

    @Override
    public B snd() {
        return _snd;
    }

    @Override
    public <C> IPaire<C, B> changeFst(C value) {
        return new Paire<>();
    }

    @Override
    public <C> IPaire<A, C> changeSnd(C value) {
        return null;
    }
}
