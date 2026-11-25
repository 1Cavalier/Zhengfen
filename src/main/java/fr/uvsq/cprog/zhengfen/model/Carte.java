package fr.uvsq.cprog.zhengfen.model;

import fr.uvsq.cprog.zhengfen.model.color.Color;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Carte à jouer du Zheng Fen, définie par une valeur (nom) et une couleur.
 *
 * <p>Chaque valeur est associée à une force ({@link #getOrder()}) qui sert à comparer les
 * cartes entre elles. Au Zheng Fen, le 3 est la carte la plus faible et le 2 la plus
 * forte : 3 &lt; 4 &lt; ... &lt; 10 &lt; J &lt; Q &lt; K &lt; A &lt; 2.
 */
public class Carte {

    /** Force de chaque valeur de carte, de 1 (le 3) à 13 (le 2). */
    private static final Map<String, Integer> CARD_ORDER;

    static {
        Map<String, Integer> order = new LinkedHashMap<>();
        order.put("3", 1);
        order.put("4", 2);
        order.put("5", 3);
        order.put("6", 4);
        order.put("7", 5);
        order.put("8", 6);
        order.put("9", 7);
        order.put("10", 8);
        order.put("J", 9);
        order.put("Q", 10);
        order.put("K", 11);
        order.put("A", 12);
        order.put("2", 13);
        CARD_ORDER = Collections.unmodifiableMap(order);
    }

    /** Rang de chaque couleur, de 1 (pique, la plus forte) à 4 (trèfle). */
    private static final Map<String, Integer> COLOR_ORDER = Map.of(
        "♠", 1,
        "♥", 2,
        "♦", 3,
        "♣", 4);

    private final String name;
    private final Color color;
    private final int order;

    /**
     * Crée une carte.
     *
     * @param name la valeur de la carte : "2" à "10", "J", "Q", "K" ou "A"
     * @param color la couleur de la carte
     * @throws IllegalArgumentException si la valeur est inconnue ou la couleur absente
     */
    public Carte(String name, Color color) {
        if (!CARD_ORDER.containsKey(name)) {
            throw new IllegalArgumentException("Valeur de carte inconnue : " + name);
        }
        if (color == null) {
            throw new IllegalArgumentException("La couleur d'une carte est obligatoire");
        }
        this.name = name;
        this.color = color;
        this.order = CARD_ORDER.get(name);
    }

    /**
     * Retourne la valeur de la carte telle qu'affichée ("A", "10", "K"...).
     *
     * @return le nom de la carte
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne la couleur de la carte.
     *
     * @return la couleur
     */
    public Color getColor() {
        return color;
    }

    /**
     * Retourne la force de la carte (1 pour le 3, 13 pour le 2).
     *
     * @return la force de la carte
     */
    public int getOrder() {
        return order;
    }

    /**
     * Retourne la force associée à une valeur de carte.
     *
     * @param valeur la valeur ("3", "K", "2"...)
     * @return la force de la valeur, ou -1 si elle est inconnue
     */
    public static int getCardOrder(String valeur) {
        return CARD_ORDER.getOrDefault(valeur, -1);
    }

    /**
     * Retourne le rang associé à un symbole de couleur.
     *
     * @param symbole le symbole de la couleur (pique, coeur, carreau ou trèfle)
     * @return le rang de la couleur (1 = pique), ou -1 si le symbole est inconnu
     */
    public static int getColorOrder(String symbole) {
        return COLOR_ORDER.getOrDefault(symbole, -1);
    }

    /** Affiche la carte sous la forme valeur puis symbole, par exemple "K♠". */
    @Override
    public String toString() {
        return name + color;
    }

    /**
     * Deux cartes sont égales si elles ont la même valeur et la même couleur.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Carte other = (Carte) obj;
        return name.equals(other.name) && color.equals(other.color);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + color.hashCode();
    }
}
