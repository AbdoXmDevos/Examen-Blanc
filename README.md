# Documentation du Projet : Architecture Microservices  

Réalisé par Abdessamad Karimi.

## Description  
Ce projet a pour objectif de développer une architecture technique basée sur des microservices en utilisant Spring Boot, Spring Cloud, Angular et Docker.  

## Étapes réalisées  

### 1. Établir une architecture technique du projet  
L'architecture adoptée repose sur les microservices, chaque service étant autonome et communicant via des API REST. Les principaux composants du projet incluent :  
- **keynote-service** : Gestion des présentations (keynotes).  
- **conference-service** : Gestion des conférences.  
- **gateway-service** : Passerelle API pour centraliser et acheminer les requêtes des clients vers les services appropriés.  
- **discovery-service** : Service de découverte basé sur Eureka, permettant l'enregistrement et la localisation des services.  
- **config-service** : Service de configuration centralisé utilisant Spring Cloud Config.  
- **angular-front-app** : Une application frontend développée en Angular (non réalisée).  

### 2. Création d'un projet Maven  
Un projet Maven multi-modules a été configuré pour inclure les différents microservices. Chaque microservice a été placé dans un module distinct, avec les dépendances nécessaires définies dans le fichier `pom.xml`.  

### 3. Développement et test des microservices de base  

#### **Discovery-service**  
- Utilisation de **Spring Cloud Netflix Eureka** pour implémenter un serveur de découverte.  
- Configuration pour permettre aux microservices de s'enregistrer dynamiquement.  
- Testé en démarrant plusieurs microservices et en vérifiant leur enregistrement dans le tableau de bord Eureka.  

#### **Gateway-service**  
- Mise en place d'une passerelle API en utilisant **Spring Cloud Gateway**.  
- Configuration des routes pour rediriger les requêtes des clients vers les services appropriés.  
- Testé en appelant les endpoints des microservices via la passerelle.  

#### **Config-service**  
- Implémenté avec **Spring Cloud Config** pour centraliser la gestion des configurations.  
- Configuration d’un répertoire Git local pour stocker les fichiers de configuration.  
- Testé en redémarrant les services et en vérifiant qu’ils récupèrent correctement leurs configurations depuis le Config Server.  

### 4. Développement et test du microservice **Keynote-service**  
- **Entities** : Création de l’entité `Keynote` avec des annotations JPA.  
- **DAO** : Implémentation d'un repository pour les opérations CRUD sur les keynotes.  
- **Service** : Développement d’un service métier pour gérer les keynotes.  
- **DTO** : Création de classes DTO pour exposer les données au format approprié via les APIs REST.  
- **Mapper** : Utilisation de MapStruct pour mapper les entités aux DTO et inversement.  
- **RestController** : Mise en place d’un contrôleur REST pour exposer des endpoints CRUD.  
- **Test** : Vérification des fonctionnalités avec des données en mémoire (H2 Database).  

### 5. Développement et test du microservice **Conference-service**  
- **Entities** : Création des entités `Conference` et `Review` avec les relations nécessaires.  
- **DAO** : Implémentation de repositories JPA pour gérer les conférences et les avis.  
- **Service** : Développement de la logique métier pour gérer les conférences et ajouter des avis.  
- **DTO** : Utilisation de DTO pour structurer les données retournées par les endpoints.  
- **Mapper** : Implémentation avec MapStruct pour convertir les entités en DTO.  
- **RestController** : Développement d’un contrôleur REST pour gérer les opérations CRUD sur les conférences.  
- **Client Rest Open Feign** : Implémentation d’un client Feign pour permettre la communication entre `conference-service` et d'autres microservices.  
- **Test** : Validation avec des tests unitaires et des tests d’intégration.  

### Étapes non réalisées  
Les étapes suivantes n'ont pas encore été implémentées :  
1. **Développement d’un frontend Angular** : Créer une interface utilisateur pour interagir avec les microservices.  
2. **Sécurisation avec Keycloak** : Ajouter une authentification et une autorisation via Keycloak.  
3. **Déploiement avec Docker et Docker Compose** : Conteneuriser les microservices et orchestrer leur déploiement avec Docker Compose.  

## Comment exécuter le projet  
1. **Configurer le Config Server** :  
   - Modifier le chemin du dépôt Git dans le fichier `application.properties` du service de configuration.  
   - Lancer `config-service`.  

2. **Démarrer Discovery-service** :  
   - Exécuter le service Eureka Discovery.  

3. **Lancer Gateway-service et les autres microservices** :  
   - Démarrer `gateway-service`, `keynote-service`, et `conference-service`.  

4. **Tester les endpoints** :  
   - Accéder aux services via la passerelle pour vérifier leur bon fonctionnement.  
