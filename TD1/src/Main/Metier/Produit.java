/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2 : POJO     */
/* Langage : Java & SQL           |                  */
/* Date : 26/09/2020              |                  */
/*****************************************************/

package Main.Metier;

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


	public Produit(Integer id, String nom, String description, Double tarif, String visuel, Categorie categorie) {
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.tarif = tarif;
		this.visuel = visuel;
		this.categorie = categorie;
	}

	public Produit() { }


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
	/**
	 * Ajouter une catégorie.
	 * @param categorie : un objet de type Categorie.
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	@Override
	public int hashCode() {
		int res = 17 * id;
		if (nom != null) {
			res += 17 * nom.hashCode();
		}
		if (description != null) {
			res += 17 * description.hashCode();
		}
		if (tarif != null) {
			res += 17 * tarif.hashCode();
		}
		if (visuel != null) {
			res += 17 * visuel.hashCode();
		}
		if (categorie != null) {
			res += 17 * categorie.hashCode();
		}
		return res;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (this.getClass() != o.getClass()) {
			return false;
		}
		Produit produit = (Produit) o;
		boolean ret = (id == produit.id);
		if (nom != null) {
			ret = ret && nom.equals(produit.nom);
		}
		if (description != null) {
			ret = ret && description.equals(produit.description);
		}
		return ret;
	}

	@Override
	public String toString() {
		return nom + " (" +categorie.getTitre()+"), "+ tarif +"euros\n"+ description;
	}
}
