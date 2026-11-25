package fr.uvsq.cprog.zhengfen.model.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests de l'ordre entre couleurs : pique &gt; coeur &gt; carreau &gt; trèfle.
 */
public class ColorTest {

    private final Spade spade = new Spade();
    private final Heart heart = new Heart();
    private final Diamond diamond = new Diamond();
    private final Club club = new Club();

    @Test
    public void clubEstLaPlusFaible() {
        assertEquals(-1, club.compareTo(spade));
        assertEquals(-1, club.compareTo(heart));
        assertEquals(-1, club.compareTo(diamond));
        assertEquals(0, club.compareTo(club));
    }

    @Test
    public void spadeEstLaPlusForte() {
        assertEquals(0, spade.compareTo(spade));
        assertEquals(1, spade.compareTo(heart));
        assertEquals(1, spade.compareTo(diamond));
        assertEquals(1, spade.compareTo(club));
    }

    @Test
    public void heartEstDeuxieme() {
        assertEquals(-1, heart.compareTo(spade));
        assertEquals(0, heart.compareTo(heart));
        assertEquals(1, heart.compareTo(diamond));
        assertEquals(1, heart.compareTo(club));
    }

    @Test
    public void diamondEstTroisieme() {
        assertEquals(-1, diamond.compareTo(spade));
        assertEquals(-1, diamond.compareTo(heart));
        assertEquals(0, diamond.compareTo(diamond));
        assertEquals(1, diamond.compareTo(club));
    }

    @Test
    public void egaliteParType() {
        assertEquals(new Spade(), spade);
        assertEquals(new Spade().hashCode(), spade.hashCode());
        assertNotEquals(spade, heart);
    }
}
