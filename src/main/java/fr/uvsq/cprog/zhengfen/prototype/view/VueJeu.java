package fr.uvsq.cprog.zhengfen.prototype.view;

import fr.uvsq.cprog.zhengfen.prototype.model.Carte;

/**
 * Vue console du jeu : seule classe du prototype qui écrit sur la sortie standard.
 */
public class VueJeu {

    /**
     * Affiche une carte tirée, ou un message si le paquet était vide.
     *
     * @param carte la carte à afficher, {@code null} si aucune carte n'a pu être tirée
     */
    public void afficherCarte(Carte carte) {
        if (carte != null) {
            System.out.println("Carte tirée : " + carte);
        } else {
            System.out.println("Aucune carte restante dans le paquet.");
        }
    }

    /**
     * Affiche un message d'information.
     *
     * @param message le message à afficher
     */
    public void afficherMessage(String message) {
        System.out.println(message);
    }
}
