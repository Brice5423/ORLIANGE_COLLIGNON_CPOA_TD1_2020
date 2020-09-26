/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   POJO           */
/* Langage : Java & SQL           |                  */
/* Date : 26/09/2020              |                  */
/*****************************************************/

package Metier;

/*
 * Pojo (Plain Old Java Object) correspondant à la classe métier 'Produit'.
 */
public class Produit {
	private Integer id;
	private String nom;
	private String description;
	private Double tarif;
	private String visuel; // Lien vers le fichier image ...
	private Categorie categorie; // Un produit est lié à une catégorie et une seule ..

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Double getTarif() {
		return tarif;
	}
	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}

	public String getVisuel() {
		return visuel;
	}
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}

	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
