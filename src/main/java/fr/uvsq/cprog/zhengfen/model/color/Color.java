package fr.uvsq.cprog.zhengfen.model.color;

/**
 * Couleur (enseigne) d'une carte : pique, coeur, carreau ou trèfle.
 *
 * <p>Plutôt qu'une énumération, chaque couleur est une sous-classe concrète. L'ordre entre
 * couleurs est défini par surcharge : chaque sous-classe indique, pour chacune des
 * quatre couleurs, si elle est plus forte (1), égale (0) ou plus faible (-1).
 * L'ordre imposé par le sujet est : pique &gt; coeur &gt; carreau &gt; trèfle.
 *
 * <p>Deux instances de la même sous-classe sont considérées comme égales, ce qui permet
 * de comparer des cartes ou de les ranger dans des collections.
 */
public abstract class Color {

    /**
     * Compare cette couleur à pique.
     *
     * @param spade la couleur pique
     * @return 1 si cette couleur est plus forte, 0 si égale, -1 si plus faible
     */
    public abstract int compareTo(Spade spade);

    /**
     * Compare cette couleur à trèfle.
     *
     * @param club la couleur trèfle
     * @return 1 si cette couleur est plus forte, 0 si égale, -1 si plus faible
     */
    public abstract int compareTo(Club club);

    /**
     * Compare cette couleur à carreau.
     *
     * @param diamond la couleur carreau
     * @return 1 si cette couleur est plus forte, 0 si égale, -1 si plus faible
     */
    public abstract int compareTo(Diamond diamond);

    /**
     * Compare cette couleur à coeur.
     *
     * @param heart la couleur coeur
     * @return 1 si cette couleur est plus forte, 0 si égale, -1 si plus faible
     */
    public abstract int compareTo(Heart heart);

    /**
     * Retourne le symbole Unicode de la couleur (par exemple le pique pour {@link Spade}).
     *
     * @return le symbole de la couleur
     */
    public abstract String getSymbol();

    /**
     * Deux couleurs sont égales si elles sont de la même sous-classe.
     */
    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getSymbol();
    }
}
