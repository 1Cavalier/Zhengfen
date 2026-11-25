package fr.uvsq.cprog.zhengfen.model.color;

/** Couleur coeur (♥), deuxième dans l'ordre pique &gt; coeur &gt; carreau &gt; trèfle. */
public class Heart extends Color {

    @Override
    public int compareTo(Spade spade) {
        return -1;
    }

    @Override
    public int compareTo(Club club) {
        return 1;
    }

    @Override
    public int compareTo(Diamond diamond) {
        return 1;
    }

    @Override
    public int compareTo(Heart heart) {
        return 0;
    }

    @Override
    public String getSymbol() {
        return "♥";
    }
}
