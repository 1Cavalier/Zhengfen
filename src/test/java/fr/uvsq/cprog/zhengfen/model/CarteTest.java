package fr.uvsq.cprog.zhengfen.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.uvsq.cprog.zhengfen.model.color.Heart;
import fr.uvsq.cprog.zhengfen.model.color.Spade;
import org.junit.jupiter.api.Test;

/**
 * Tests de la classe {@link Carte}.
 */
public class CarteTest {

    @Test
    public void deuxPlusFortQueAs() {
        assertTrue(new Carte("2", new Spade()).getOrder() > new Carte("A", new Spade()).getOrder());
        assertEquals(1, Carte.getCardOrder("3"));
        assertEquals(-1, Carte.getCardOrder("1"));
    }

    @Test
    public void egaliteSurValeurEtCouleur() {
        assertEquals(new Carte("K", new Spade()), new Carte("K", new Spade()));
        assertNotEquals(new Carte("K", new Spade()), new Carte("K", new Heart()));
        assertNotEquals(new Carte("K", new Spade()), new Carte("Q", new Spade()));
    }

    @Test
    public void affichage() {
        assertEquals("K♠", new Carte("K", new Spade()).toString());
    }

    @Test
    public void valeurInconnueRefusee() {
        assertThrows(IllegalArgumentException.class, () -> new Carte("Z", new Spade()));
        assertThrows(IllegalArgumentException.class, () -> new Carte("K", null));
    }
}
