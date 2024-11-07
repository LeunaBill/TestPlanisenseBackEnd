# TestPlanisense Backend - Arbres en région Parisienne

TestPlanisense est une API qui permet de récupérer le nombre d'arbres en région Parisienne par arrondissement et par genre. 

## Prérequis

- Java 17 ou version ultérieure
- Maven
- Spring Boot
- [Base de données des arbres de Paris](https://opendata.paris.fr/explore/dataset/les-arbres/export/?disjunctive.typeemplacement&disjunctive...)

## Installation

### 1. Cloner le projet

Clonez ce projet à l'aide de Git :

```bash
git clone https://github.com/LeunaBill/TestPlanisenseBackEnd.git
```

### 2. Installer les dépendances

Naviguez vers le répertoire du projet et exécutez la commande suivante pour installer les dépendances via Maven :

```bash
mvn install
```

### 3. Configurer la base de données

Téléchargez les données des arbres de Paris à partir du lien suivant et importez-les dans votre base de données relationnelle.

[Base de données des arbres de Paris](https://opendata.paris.fr/explore/dataset/les-arbres/export/?disjunctive.typeemplacement&disjunctive...)

### 4. Lancer l'application

Pour démarrer l'application, exécutez la commande suivante :

```bash
mvn spring-boot:run
```

L'application sera accessible à l'adresse suivante : http://localhost:8080.

### 5. Tests Unitaires

Les tests sont inclus dans le projet, et vous pouvez les exécuter avec Maven. Les tests couvrent les composants suivants :

- **Controller** : ***ArbreControllerTest*** vérifie les points d'entrée de l'API.
- **Service** : ***ArbreServiceTest*** teste la logique métier.
- **Repository** : ***ArbreRepositoryTest*** teste l'accès aux données.

Pour exécuter les tests, utilisez la commande suivante :

```bash
mvn test
```