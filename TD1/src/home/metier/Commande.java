package home.metier;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


// Pojo (Plain Old Java Object) correspondant à la classe métier 'Commande'.//
public class Commande {
	private int id;
	private Date date;
	private Client client;

	// Ligne de commande : liste des produits.
	// Une Commande contient '1 ou n' produits.
	private Map<Produit, Integer> produits;


	public Commande(int id, Date date, Client client, Map<Produit, Integer> produits) {
		this.id = id;  // Ligne_commande / Commande
		this.date = date; // Commande
		this.client = client; // Commande => Client
		this.produits = produits; // Ligne_commande => Produit / Commande
	}

	public Commande() { }


	public int getId() {
		return id;
	}
	public void setId(int num) {
		this.id = num;
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
	public void setProduits(Map<Produit, Integer> produits) {
		this.produits = produits;
	}


	/** @return le montant total du panier (ligne de commande). */
	public Double getMontantTotal() {
		// Parcours de la table des produits ...ligne de commande. //
		Double resultat = 0d;
		for (Map.Entry<Produit, Integer> entry : produits.entrySet()) {
			// Pour chaque ligne de commande je récupère la clé (produit) et la valeur (quantité). //
			Produit produit = entry.getKey();
			Integer quantite = entry.getValue();
			resultat += (produit.getTarif() * quantite);
		}
		return resultat;
	}

	/** Méthode qui permet d'ajouter un produit à la ligne de commande. */
	public void addProduit(Produit produit, Integer quantite) {
		if (produits == null) {
			produits = new HashMap<>();
		}
		produits.put(produit, quantite);
	}


	@Override
	public String toString() {
		return "id " + this.id + ", date : " + this.date + ", Client : " + client.getNom() + ", produit : " + this.produits;
	}

	public String toStringController() {
		return this.client.getNom();
	}
}
