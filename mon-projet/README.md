# TP1 Revue de Code



## Objectif

L'objectif de ce TP est d'appliquer les principes et outils du génie logiciel pour transformer le code Java initialement développé par un stagiaire en un projet bien structuré, maintenable et professionnel. Cela inclut l'organisation du code, l'ajout de tests unitaires, la documentation, et l'utilisation de bonnes pratiques de développement pour assurer la qualité et la robustesse du projet.






## Structure du projet

Le projet utilise Maven pour la gestion des dépendances et la construction. Il a été initialisé avec la commande suivante :

mvn archetype:generate -DgroupId=com.isima.codeReview -DartifactId=password-strength-calculator -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
Maven permet de structurer le projet de manière standardisée, facilitant ainsi la gestion des dépendances, la compilation, les tests et le déploiement. Grâce à cette commande, nous avons créé un projet de démarrage rapide qui inclut une structure de base pour les sources et les tests, ainsi qu'un fichier pom.xml pour la configuration du projet.


### Instancier
Instancier la classe en utilisant :
AwesomePasswordChecker.getInstance()

soit en lui fournissant un fichier (file) comme : "cluster_centers_HAC_aff.csv"
soit en ne mettant aucun paramètre, pour utiliser le fichier par défaut

### Compilation

Pour compiler le code, il a été nécessaire d'importer les bibliothèques java.nio.ByteBuffer et java.nio.ByteOrder. Ces bibliothèques sont essentielles pour gérer les opérations de buffer et l'ordre des octets, ce qui est crucial pour certaines fonctionnalités du projet.

En outre, nous avons corrigé quelques bugs présents dans le code initial, notamment des erreurs dans la lecture du fichier CSV et dans la formule de calcul de la distance euclidienne. Ces corrections ont permis d'assurer le bon fonctionnement du programme.

Il est également important de spécifier la version correcte de Java dans le fichier pom.xml. Cela garantit que Maven utilise la bonne version de l'environnement Java pour compiler le projet. Une fois cette configuration effectuée, vous pouvez lancer la compilation avec la commande suivante :

mvn clean compile
Cette commande nettoie le projet et compile le code source, en s'assurant que toutes les dépendances sont correctement résolues et que le code est prêt pour l'exécution ou les tests.

### Javadoc

Pour documenter le code, nous utilisons Javadoc. Cette approche permet de générer automatiquement une documentation détaillée à partir des commentaires insérés directement dans le code source.

Après avoir ajouté des commentaires Javadoc pour chaque méthode et configuré le plugin Javadoc dans le fichier pom.xml, nous pouvons générer la documentation avec la commande suivante :

mvn javadoc:javadoc
Cette commande crée un dossier site dans le répertoire target, contenant des pages HTML qui documentent les différentes méthodes et classes du projet. Ces pages fournissent une vue structurée et navigable de la documentation, facilitant ainsi la compréhension et l'utilisation du code par d'autres développeurs.

## Tests unitaires

Pour tester le programme, on va utiliser la bibliothèque JUnit 5. Pour cela, on va importer les dépendances nécessaires dans le projet et créer une classe de test `AwesomePasswordCheckerTest`. Dans cette classe, on va pouvoir écrire nos tests unitaires et lancer tous les tests avec :
```
mvn test
```

## SCM

### Security.md

Ce document permet de fournir des informations relatives à la sécurité dans un dépôt GitHub. Il a été rédigé par ChatGPT car c'est seulement un exemple de fichier qui peut être adapté selon les besoins.




### Jacoco

Pour vérifier que les tests unitaires couvre bien l'ensemble du code, on utilise un outil appelé Jococo qui va analyser le code coverage et faire un rapport pour indiquer les parties du code non testés.
