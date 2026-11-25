# Zheng Fen - Jeu de cartes en ligne de commande

Base d'un jeu de cartes Zheng Fen en Java, centrée sur la conception objet : modélisation des cartes et de leurs couleurs, et prototype d'architecture MVC pour la future boucle de jeu.

## Contexte

- Projet réalisé dans le cadre du Master 1 Informatique de l'UVSQ (Université Paris-Saclay)
- UE : Programmation avancée Java
- Année universitaire : 2024-2025
- Travail en équipe de 4 étudiants : Ethan Mache, Théo Joly, Théotime Turmel, Quentin Soumet

Le sujet demandait de réaliser le jeu de cartes [Zheng Fen](https://www.pagat.com/climbing/zhengfen.html), un jeu de défausse chinois, jouable dans un terminal par des joueurs humains et des joueurs virtuels. Le travail portait surtout sur les choix de conception orientée objet.

**État du projet :** ce dépôt contient la première étape du travail, à savoir le modèle des cartes et une démonstration de l'architecture MVC. La boucle de jeu complète (manches, combinaisons, joueurs virtuels, scores) n'est pas implémentée.

## Fonctionnalités

- Modélisation d'une carte du Zheng Fen avec sa force : le 3 est la plus faible, le 2 la plus forte (3 < 4 < ... < K < A < 2).
- Hiérarchie de couleurs (pique, coeur, carreau, trèfle) sous forme de sous-classes, avec un ordre défini par surcharge : pique > coeur > carreau > trèfle.
- Égalité et hachage cohérents des cartes et des couleurs, pour pouvoir les ranger dans des collections.
- Validation des cartes à la construction : une valeur inconnue ou une couleur absente lève une exception.
- Prototype MVC : paquet de 54 cartes (52 cartes et 2 jokers), mélange et tirage affiché en console.
- Tests unitaires JUnit 5 sur l'ordre des couleurs et sur les cartes.
- Respect des règles de codage Google, vérifié par Checkstyle à chaque build.

## Technologies utilisées

- Java 17 (ou plus récent)
- Maven, via le Maven Wrapper fourni (`mvnw`)
- JUnit 5 pour les tests unitaires
- Checkstyle (règles Google, indentation à 4 espaces)

## Structure du projet

```
zhengfen/
├── .mvn/wrapper/                  Configuration du Maven Wrapper
├── checkstyle.xml                 Règles de style vérifiées au build
├── mvnw, mvnw.cmd                 Maven Wrapper (Linux/macOS, Windows)
├── pom.xml                        Configuration Maven
└── src/
    ├── main/java/fr/uvsq/cprog/zhengfen/
    │   ├── Main.java              Point d'entrée de l'application (Singleton)
    │   ├── model/
    │   │   ├── Carte.java         Carte : valeur, couleur et force
    │   │   └── color/             Couleurs : Color (abstraite), Spade, Heart, Diamond, Club
    │   └── prototype/             Démonstration de l'architecture MVC
    │       ├── PrototypeMain.java Lancement de la démonstration
    │       ├── model/             Carte et PaquetDeCartes
    │       ├── view/              VueJeu, affichage console
    │       └── controller/        JeuController, relie modèle et vue
    └── test/java/fr/uvsq/cprog/zhengfen/model/
        ├── CarteTest.java
        └── color/ColorTest.java
```

## Choix de conception

- **Couleurs en sous-classes.** Chaque couleur est une classe qui hérite de `Color` et indique, pour chacune des quatre couleurs, si elle est plus forte, égale ou plus faible. Ajouter une règle propre à une couleur revient à modifier une seule classe.
- **Singleton par énumération.** `Main` est une énumération à une seule constante, `APPLICATION`. En Java, c'est la façon la plus simple d'obtenir un Singleton sûr.
- **MVC dans le prototype.** Le contrôleur agit sur le modèle, et la vue est la seule classe qui écrit dans le terminal. On peut ainsi changer l'affichage, par exemple pour ajouter des couleurs ANSI, sans toucher à la logique.

## Installation et prérequis

- Un JDK 17 ou plus récent (par exemple [Eclipse Temurin](https://adoptium.net/))
- Aucune installation de Maven n'est nécessaire : le wrapper télécharge la bonne version.

```bash
git clone https://github.com/[À COMPLÉTER]/[NOM-DU-DEPOT].git
cd [NOM-DU-DEPOT]
```

## Utilisation

Compiler, lancer Checkstyle et les tests, puis produire le jar :

```bash
./mvnw package          # Linux / macOS (si besoin : chmod +x mvnw)
mvnw.cmd package        # Windows
```

Lancer uniquement les tests :

```bash
./mvnw test
```

Lancer la démonstration du prototype MVC (mélange du paquet et tirage de 5 cartes) :

```bash
java -cp target/zhengfen-1.0-SNAPSHOT.jar fr.uvsq.cprog.zhengfen.prototype.PrototypeMain
```

Le point d'entrée principal (`java -jar target/zhengfen-1.0-SNAPSHOT.jar`) existe déjà, mais il ne lance encore aucune partie.

## Exemple de sortie

Comme le paquet est mélangé, les cartes tirées changent à chaque exécution :

```
Jeu mélangé. Tirage en cours...
Carte tirée : HUIT de COEUR
Carte tirée : NEUF de PIQUE
Carte tirée : DEUX de PIQUE
Carte tirée : DEUX de TREFLE
Carte tirée : CINQ de TREFLE
```

[Capture d'écran à ajouter : docs/demo.png]

## Pistes d'amélioration

- Fusionner les deux modèles de carte (`model.Carte` et `prototype.model.Carte`) en un seul.
- Compléter le double dispatch des couleurs avec une méthode `compareTo(Color)`, pour comparer deux couleurs dont le type exact n'est pas connu à la compilation.
- Implémenter les combinaisons du Zheng Fen (simple, paire, brelan, suite, bombe) et leur saisie au format `K(SHD), Q(DC)`.
- Ajouter la boucle de jeu : manches, tour de table, passe, abandon, décompte des points jusqu'à 500.
- Créer des joueurs virtuels interchangeables (patron Stratégie), avec une stratégie triviale et une stratégie plus élaborée.
- Ajouter l'affichage coloré par joueur (JAnsi), un mode débogage à jeu ouvert et la sauvegarde de l'historique des parties.
- Intégrer la couverture de code (JaCoCo) et produire un jar exécutable avec toutes ses dépendances.

## Auteurs

Projet d'équipe réalisé par Ethan Mache, Théo Joly, Théotime Turmel et Quentin Soumet.

Dépôt publié par [À COMPLÉTER : ton nom] - [À COMPLÉTER : lien vers ton profil GitHub]

## Licence

[À COMPLÉTER : par exemple MIT, après accord des membres de l'équipe. Voir le fichier LICENSE.]
