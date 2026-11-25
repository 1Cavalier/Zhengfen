package fr.uvsq.cprog.zhengfen.prototype.controller;

import fr.uvsq.cprog.zhengfen.prototype.model.Carte;
import fr.uvsq.cprog.zhengfen.prototype.model.PaquetDeCartes;
import fr.uvsq.cprog.zhengfen.prototype.view.VueJeu;

/**
 * Contrôleur du jeu : orchestre les échanges entre le modèle et la vue.
 *
 * <p>Le contrôleur ne fait aucun affichage lui-même : il agit sur le modèle puis délègue
 * la présentation du résultat à la vue.
 */
public class JeuController {

    /** Nombre de cartes tirées lors de la démonstration. */
    private static final int NB_CARTES_TIREES = 5;

    private final PaquetDeCartes paquet;
    private final VueJeu vue;

    /**
     * Crée un contrôleur reliant un paquet de cartes et une vue.
     *
     * @param paquet le paquet de cartes (modèle)
     * @param vue la vue chargée de l'affichage
     */
    public JeuController(PaquetDeCartes paquet, VueJeu vue) {
        this.paquet = paquet;
        this.vue = vue;
    }

    /** Mélange le paquet puis tire et affiche quelques cartes. */
    public void demarrerJeu() {
        paquet.melanger();
        vue.afficherMessage("Jeu mélangé. Tirage en cours...");

        for (int i = 0; i < NB_CARTES_TIREES; i++) {
            Carte carte = paquet.tirerCarte();
            vue.afficherCarte(carte);
        }
    }
}
