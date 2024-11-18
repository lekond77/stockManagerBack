#  Backend (Java/Spring Boot) - StockManager

## Description

This is the Backend part of the StockManager application, built using Spring Boot. 
It exposes RESTful API endpoints to manage the product inventory. 
The backend supports operations like viewing products, retrieving product details, updating product information, and deleting products. 

## Configuration

**JWT Authentication**: The backend uses JWT (JSON Web Tokens) for secure authentication.

**Database**: The application uses a database to store product details.  
Make sure your database is properly set up and connected. 
You can configure database settings in the application.properties file. 

- spring.datasource.url=jdbc:mysql://localhost:3306/stockmanager
- spring.datasource.username=your_username
- spring.datasource.password=your_password

- jwt.secret=your_secret_key (generate one here : https://jwtsecret.com/)

## API Endpoints

- POST http://localhost:8085/produit: Create a new product.
- GET http://localhost:8085/produit/{id}: Get product details by ID.
- PUT http://localhost:8085/produit/{id}: Update product details by ID.
- DELETE http://localhost:8085/produit/{id}: Delete a product by ID.

## Technologies Used
- Spring Boot (Backend Framework)
- Spring Data JPA (Database Interaction)
- JWT Authentication (JSON Web Tokens)
- MySQL (Database)
- Maven (Build Tool)

## Clone the repository
  
    ```bash
    git clone git@github.com:lekond77/stockManagerBack.git

Front-end repository available here : https://github.com/lekond77/stockManagerFront

## Description
Ceci est la partie Backend de l'application StockManager, réalisée avec Spring Boot. 
Elle expose des endpoints API RESTful pour gérer l'inventaire des produits. 
Le backend prend en charge des opérations telles que la visualisation des produits, 
la récupération des détails d'un produit, la mise à jour des informations d'un produit et la suppression de produits. 

## Configuration
- Authentification JWT : Le backend utilise JWT (JSON Web Tokens) pour une authentification sécurisée.

- Base de données : L'application utilise une base de données pour stocker les détails des produits.
Assurez-vous que votre base de données est correctement configurée et connectée.
Vous pouvez configurer les paramètres de la base de données dans le fichier application.properties.

**Exemple de configuration** :

- spring.datasource.url=jdbc:mysql://localhost:3306/stockmanager
- spring.datasource.username=your_username
- spring.datasource.password=your_password
- jwt.secret=your_secret_key (générez une clé ici : https://jwtsecret.com/)

## Endpoints de l'API
- POST http://localhost:8085/produit : Créer un nouveau produit.
- GET http://localhost:8085/produit/{id} : Récupérer les détails d'un produit par son ID.
- PUT http://localhost:8085/produit/{id} : Mettre à jour les détails d'un produit par son ID.
- DELETE http://localhost:8085/produit/{id} : Supprimer un produit par son ID.

## Technologies Utilisées
- Spring Boot (Framework Backend)
- Spring Data JPA (Interaction avec la base de données)
- Authentification JWT (JSON Web Tokens)
- MySQL (Base de données)
- Maven (Outil de construction)

## Cloner le dépôt
    ```bash
    git clone git@github.com:lekond77/stockManagerBack.git 
    
Le dépôt du Frontend est disponible ici : https://github.com/lekond77/stockManagerFront
