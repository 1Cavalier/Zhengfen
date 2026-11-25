package fr.uvsq.cprog.zhengfen;

/**
 * Point d'entrée de l'application Zheng Fen.
 *
 * <p>L'application est représentée par l'unique constante {@code APPLICATION} de cette
 * énumération : c'est une façon idiomatique en Java d'implémenter le patron Singleton
 * (une seule instance, créée par la JVM, sûre en contexte multi-thread).
 *
 * <p>La boucle de jeu n'est pas encore branchée ici. En attendant, une démonstration du
 * modèle MVC (mélange du paquet et tirage de cartes) est disponible dans
 * {@link fr.uvsq.cprog.zhengfen.prototype.PrototypeMain}.
 *
 * @see <a href="https://refactoring.guru/fr/design-patterns/singleton">Pattern Singleton</a>
 */
public enum Main {
    APPLICATION;

    /**
     * Crée les objets principaux de l'application et lance leurs interactions.
     *
     * @param args les paramètres de la ligne de commande
     */
    public void run(String[] args) {
        // À compléter : création des joueurs, de la configuration et de la partie.
    }

    /**
     * Méthode appelée par la JVM au lancement du programme.
     *
     * @param args les paramètres de la ligne de commande
     */
    public static void main(String[] args) {
        APPLICATION.run(args);
    }
}
