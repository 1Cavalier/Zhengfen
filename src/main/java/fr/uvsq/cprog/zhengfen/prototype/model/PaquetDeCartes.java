package fr.uvsq.cprog.zhengfen.prototype.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Paquet de 54 cartes : 52 cartes classiques et 2 jokers.
 */
public class PaquetDeCartes {

    private final List<Carte> cartes;

    /** Crée un paquet complet, non mélangé. */
    public PaquetDeCartes() {
        cartes = new ArrayList<>();
        for (Carte.Couleur couleur : Carte.Couleur.values()) {
            for (Carte.Valeur valeur : Carte.Valeur.values()) {
                // Le joker n'appartient à aucune couleur : il est ajouté à part.
                if (valeur != Carte.Valeur.JOKER) {
                    cartes.add(new Carte(couleur, valeur));
                }
            }
        }
        cartes.add(new Carte(null, Carte.Valeur.JOKER));
        cartes.add(new Carte(null, Carte.Valeur.JOKER));
    }

    /** Mélange aléatoirement les cartes du paquet. */
    public void melanger() {
        Collections.shuffle(cartes);
    }

    /**
     * Retire et retourne la carte du dessus du paquet.
     *
     * @return la carte tirée, ou {@code null} si le paquet est vide
     */
    public Carte tirerCarte() {
        if (cartes.isEmpty()) {
            return null;
        }
        return cartes.remove(0);
    }

    /**
     * Retourne le nombre de cartes restant dans le paquet.
     *
     * @return le nombre de cartes
     */
    public int taille() {
        return cartes.size();
    }
}
