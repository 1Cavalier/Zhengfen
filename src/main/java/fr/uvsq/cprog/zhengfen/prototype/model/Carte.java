package fr.uvsq.cprog.zhengfen.prototype.model;

/**
 * Carte à jouer du prototype MVC, définie par une couleur et une valeur.
 *
 * <p>Les jokers n'ont pas de couleur : leur couleur vaut {@code null}.
 */
public class Carte {

    /** Les quatre couleurs d'un jeu classique. */
    public enum Couleur {
        COEUR, CARREAU, TREFLE, PIQUE
    }

    /** Les valeurs possibles d'une carte, joker compris. */
    public enum Valeur {
        AS, DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI, JOKER
    }

    private final Couleur couleur;
    private final Valeur valeur;

    /**
     * Crée une carte.
     *
     * @param couleur la couleur de la carte, {@code null} pour un joker
     * @param valeur la valeur de la carte
     */
    public Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    /**
     * Retourne la couleur de la carte.
     *
     * @return la couleur, ou {@code null} pour un joker
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Retourne la valeur de la carte.
     *
     * @return la valeur
     */
    public Valeur getValeur() {
        return valeur;
    }

    /** Affiche la carte, par exemple "ROI de PIQUE" ou "JOKER". */
    @Override
    public String toString() {
        if (couleur == null) {
            return valeur.toString();
        }
        return valeur + " de " + couleur;
    }
}
