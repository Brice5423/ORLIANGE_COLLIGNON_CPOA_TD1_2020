/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   POJO           */
/* Langage : Java & SQL           |                  */
/* Date : 26/09/2020              |                  */
/*****************************************************/

package Metier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * Réprésentation métier d'une 'commande'.
 * Une commande est réalisée à une date par un client.
 * Et contient plusieurs produits.
 */
public class Commande {
	private int num;
	private Date date;
	private Client client; // Une commande est réalisée par un client

	// Ligne de commande : liste des produits.
	// Une Commande contient '1 ou n' produits.
	private Map<Produit, Integer> produits;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public Map<Produit, Integer> getProduits() {
		return produits;
	}


	/* @return le montant total du panier (ligne de commande). */
	public Double getMontantTotal() {
		// Parcours de la table des produits ...ligne de commande.
		Double resultat = 0d;
		for (Map.Entry<Produit, Integer> entry : produits.entrySet()) {
			// Pour chaque ligne de commande je récupère la clé (produit) et la valeur
			// (quantité).
			Produit produit = entry.getKey();
			Integer quantite = entry.getValue();
			resultat += (produit.getTarif() * quantite);
		}
		return resultat;
	}

	/* Méthode qui permet d'ajouter un produit à la ligne de commande. */
	public void addProduit(Produit produit, Integer quantite) {
		if (produits == null) {
			produits = new HashMap<>();
		}
		produits.put(produit, quantite);
	}
}