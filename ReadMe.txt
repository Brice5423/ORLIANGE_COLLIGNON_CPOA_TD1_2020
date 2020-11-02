Pourcentage de travail avec répartition des tâches: 
		
	- Brice Orliange : 60% (pur code) :
				- DAO commande et MySQL.
				- test commande.
	- Nicolas Collignon : 40 % (interface et code) :
				- Toute l'interface graphique (sample).
	- Les 2 :
		- DAO (sauf commande et MySQL).
		- POJO.
		- Controller.
		- tests (sauf commande).
		- Connexion.
		- Main.
----------------------------------------------------------------------------

Ce qui marche dans l'application :

	- Menu :
		- Le choix entre Liste Mémoire et MYSQL.
		- Bouton Commande/Client/Produit/Catégorie.
		- Bouton de fermeture de l'application.

	- MySQL :

		- Catégorie :
			- Affichage de la page.
			- Vérifications des Erreurs pour créer et modifier (sauf tarif).
			- Création / Modification / Supression d'une catégorie.
			- Mise à jour (remplissage) de la table de données après création /  modification / suppression d'une catégorie.
			- Message quand on créer / modifie une catégorie.

		- Client :
			- Affichage de la page.
			- Vérifications des Erreurs pour créer et modifier (sauf tarif).
			- Message quand on créer / modifie un client.

		- Commande :

		- Produit :
			- Affichage de la page.
			- Vérifications des Erreurs pour créer et modifier (sauf tarif).
			- Création / Supression d'un produit.
			- Mise à jour (remplissage) de la table de données après création / suppression d'un produit.
			- Message quand on créer un produit.


	- Liste Mémoire :

		- Catégorie : 
			- Affichage de la page.
			- Vérifications des Erreurs pour créer et modifier.
			- Création / Modification / Supression d'une catégorie.
			- Mise à jour (remplissage) de la table de données après création / modification / suppression d'une catégorie.
			- Message quand on créer / modifie une catégorie.
			- Après création et modification les champs sont vides.
			- Quand on refresh la page redevient comme au début.
			-

		- Client :
			- Affichage de la page.
			- Vérifications des Erreurs pour créer et modifier.
			- Création / Modification / Supression d'un client.
			- Mise à jour (remplissage) de la table de données après création / modification / suppression d'un client.
			- Message quand on créer / modifie une catégorie.
			- Après création et modification les champs sont vides.
			- Quand on refresh la page redevient comme au début.

		- Commande :
			- Affichage de la page.

		- Produit :
			- Vérifications des Erreurs pour créer et modifier.
			- Création / Supression d'un produit.
			- Mise à jour (remplissage) de la table de données après création / suppression d'un produit.
			- Message quand on créer un produit.
			- Quand on refresh la page redevient comme au début.


Ce qui ne marche pas dans l'application :

	- MySQL :

		- Catégorie :
			- les valeurs de la table se cumulent.

		- Client :
			- les valeurs de la table se cumulent.
			- problème de modification dans MYSQL.

		- Commande :
			- les valeurs de la table se cumulent.

		- Produit : 
			- les valeurs de la table se cumulent.
			- Problème de modification avec le tarif ce qui fait que l'on ne peut pas modifier, voir le message et que ça actualise la table de donnée.
			
	- Liste Mémoire :

		- Commande :

		- Produit :
			- Problème de modification avec le tarif ce qui fait que l'on ne peut pas modifier, voir le message et que ça actualise la table de donnée.
