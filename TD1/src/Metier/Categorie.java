/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   POJO           */
/* Langage : Java & SQL           |                  */
/* Date : 26/09/2020              |                  */
/*****************************************************/

package Metier;

import java.util.List;

/*
 * Pojo (Plain Old Java Object) correspondant à la classe métier 'Catégorie'.
 */
public class Categorie {
	private Integer id;
	private String titre;
	private String visuel;

	// Une catégorie appartient à 0 ou plusieurs produits.
	private List<Produit> produits;


	public Categorie(int id, String titre, String visuel) {
		this.id = id;
		this.titre = titre;
		this.visuel = visuel;
	}

	public Categorie() { }


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getVisuel() {
		return visuel;
	}
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}

	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}
