![HydroGrow logo](/images/HydroGrow-2.png)

# HydroGrow

Ce projet consiste en un logiciel Java pour un système hydroponique qui permet de surveiller et de contrôler l'environnement de culture pour différentes plantes.

**Note importante : Ce projet est en cours de développement et le logiciel n'est pas encore opérationnel.**

## Fonctionnalités

Le logiciel offre les fonctionnalités suivantes :

- Entrée manuelle des valeurs d'environnement telles que la température, l'humidité, etc.
- Recommandations sur les changements nécessaires pour optimiser la croissance des plantes en fonction des valeurs d'environnement entrées
- Adaptation automatique du logiciel à différentes plantes et conditions de croissance
- Intégration de capteurs pour automatiser le processus de surveillance et de contrôle
- Ajout d'une API pour permettre l'accès à distance au système

## Arborescence du projet

(Exemple d'arborescence)
Le projet est structuré de la manière suivante :

<!--
- Projet Hydroponique
  - src
    - Main.java
    - Environnement.java
    - Plante.java
    - SystemeHydroponique.java
  - lib
    - librairie1.jar
    - librairie2.jar
  - data
    - plantes.csv
    - environnements.csv
  - docs
    - diagrammes
      - diagramme de classes.png
      - diagramme de séquence.png
    - manuel_utilisateur.pdf
    - manuel_technique.pdf
  - tests
    - TestEnvironnement.java
    - TestPlante.java
    - TestSystemeHydroponique.java
  - README.md
  - LICENSE

tree /f
-->

```bash
HydroGrow
│   .classpath
│   .project
│   pom.xml
│
├───.settings
│       org.eclipse.jdt.apt.core.prefs
│       org.eclipse.jdt.core.prefs
│       org.eclipse.m2e.core.prefs
│
├───src
│   ├───main
│   │   ├───java
│   │   │   ├───bdd
│   │   │   │   │   HydroBaseManager.java
│   │   │   │   │   HydroTableItems.java
│   │   │   │   │   HydroTablePlante.java
│   │   │   │   │
│   │   │   │   └───models
│   │   │   │           Plante.java
│   │   │   │
│   │   │   ├───executable
│   │   │   │       Index.java
│   │   │   │       InterfaceJFrame.java
│   │   │   │
│   │   │   └───hybernate
│   │   │           HibernateUtil.java
│   │   │
│   │   └───resources
│   │           hibernate.cfg.xml
│   │
│   └───test
│       ├───java
│       └───resources
└───target
    ├───classes
    │   │   hibernate.cfg.xml
    │   │
    │   ├───bdd
    │   │   │   HydroBaseManager.class
    │   │   │   HydroTableItems.class
    │   │   │   HydroTablePlante.class
    │   │   │
    │   │   └───models
    │   │           Plante.class
    │   │
    │   ├───executable
    │   │       Index.class
    │   │       InterfaceJFrame$1.class
    │   │       InterfaceJFrame.class
    │   │
    │   ├───hybernate
    │   │       HibernateUtil.class
    │   │
    │   └───META-INF
    │       │   MANIFEST.MF
    │       │
    │       └───maven
    │           └───fr
    │               └───HydroM
    │                       pom.properties
    │                       pom.xml
    │
    └───test-classes
```

## Comment utiliser le logiciel

Le manuel utilisateur et le manuel technique sont disponibles dans le dossier "docs" pour vous aider à utiliser le logiciel.

## Licence

Ce projet est sous licence MIT. Veuillez vous référer au fichier LICENSE pour plus d'informations.
