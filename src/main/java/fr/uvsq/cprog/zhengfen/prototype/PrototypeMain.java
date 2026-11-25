package fr.uvsq.cprog.zhengfen.prototype;

import fr.uvsq.cprog.zhengfen.prototype.controller.JeuController;
import fr.uvsq.cprog.zhengfen.prototype.model.PaquetDeCartes;
import fr.uvsq.cprog.zhengfen.prototype.view.VueJeu;

/**
 * Démonstration de l'architecture MVC proposée pour le jeu.
 *
 * <p>Assemble le modèle (le paquet), la vue (affichage console) et le contrôleur, puis
 * lance un tirage de cinq cartes.
 */
public class PrototypeMain {

    /**
     * Lance la démonstration.
     *
     * @param args les paramètres de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        PaquetDeCartes paquet = new PaquetDeCartes();
        VueJeu vue = new VueJeu();
        JeuController controller = new JeuController(paquet, vue);
        controller.demarrerJeu();
    }
}
