package TD1;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import TD1.ArbresGeneralises.*;

public class ArbreGeneralisesTest {

    Entier un = new Entier(1);
    Entier deux = new Entier(2);
    Entier trois = new Entier(3);
    Entier quatre = new Entier(4);

    public static final Arbre<Entier> arbre1() {
        final Arbre<Entier> f1 = new Feuille<>(new Entier(1));
        final Arbre<Entier> f2 = new Feuille<>(new Entier(2));
        final Arbre<Entier> n1 = new Noeud<>(List.of(f1, f2));
        final Arbre<Entier> f3 = new Feuille<>(new Entier(3));
        final Arbre<Entier> n2 = new Noeud<>(List.of(n1, f3));
        return n2;
    }

    public static final Arbre<Entier> arbre2() {
        final Arbre<Entier> f1 = new Feuille<>(new Entier(2));
        final Arbre<Entier> f2 = new Feuille<>(new Entier(3));
        final Arbre<Entier> n1 = new Noeud<>(List.of(f1, f2));
        final Arbre<Entier> f3 = new Feuille<>(new Entier(1));
        final Arbre<Entier> n2 = new Noeud<>(List.of(n1, f3));
        return n2;
    }

    public static final Arbre<Entier> arbre3() {
        final Arbre<Entier> f1 = new Feuille<>(new Entier(2));
        final Arbre<Entier> f2 = new Feuille<>(new Entier(1));
        final Arbre<Entier> n1 = new Noeud<>(List.of(f1, f2));
        final Arbre<Entier> f3 = new Feuille<>(new Entier(3));
        final Arbre<Entier> n2 = new Noeud<>(List.of(n1, f3));
        return n2;
    }

    public static final Arbre<Chaine> arbre4() {
        final Arbre<Chaine> f1 = new Feuille<>(new Chaine("deux"));
        final Arbre<Chaine> f2 = new Feuille<>(new Chaine("un"));
        final Arbre<Chaine> n1 = new Noeud<>(List.of(f1, f2));
        final Arbre<Chaine> f3 = new Feuille<>(new Chaine("trois"));
        final Arbre<Chaine> n2 = new Noeud<>(List.of(n1, f3));
        return n2;
    }

    @Test
    public void testSize() {
        assertEquals(3, arbre1().taille());
        assertEquals(3, arbre2().taille());
        assertEquals(3, arbre3().taille());
        assertEquals(3, arbre4().taille());
    }

    @Test
    public void testContient() {
        assertTrue(arbre1().contient(un));
        assertTrue(arbre2().contient(un));
        assertTrue(arbre3().contient(un));
        // assertTrue(arbre4().contient("un"));
        assertTrue(arbre1().contient(deux));
        assertTrue(arbre2().contient(deux));
        assertTrue(arbre3().contient(deux));
        // assertTrue(arbre4().contient("deux"));
        assertTrue(arbre1().contient(trois));
        assertTrue(arbre2().contient(trois));
        assertTrue(arbre3().contient(trois));
        // assertTrue(arbre4().contient("trois"));
        assertFalse(arbre1().contient(quatre));
        assertFalse(arbre2().contient(quatre));
        assertFalse(arbre3().contient(quatre));
        // assertFalse(arbre4().contient("quatre"));
    }

    @Test
    public void testValeurs() {
        final Set<Entier> contenuEntier = Set.of(un, deux, trois);
        // final Set<Chaine> contenuChaine = Set.of("un", "deux", "trois");
        assertEquals(contenuEntier, arbre1().valeurs());
        assertEquals(contenuEntier, arbre2().valeurs());
        assertEquals(contenuEntier, arbre3().valeurs());
        // assertEquals(contenuChaine, arbre4().valeurs());
    }

    @Test
    public void testValeur() {
        assertEquals(6, arbre1().somme());
        assertEquals(6, arbre2().somme());
        assertEquals(6, arbre3().somme());
    }

    @Test
    public void testMin() {
        assertEquals(1, arbre1().min());
        assertEquals(1, arbre2().min());
        assertEquals(1, arbre3().min());
    }

    @Test
    public void testMax() {
        assertEquals(3, arbre1().max());
        assertEquals(3, arbre2().max());
        assertEquals(3, arbre3().max());
    }

    @Test
    public void testEstTrie() {
        assertTrue(arbre1().estTrie());
        assertFalse(arbre2().estTrie());
        assertFalse(arbre3().estTrie());
    }

}