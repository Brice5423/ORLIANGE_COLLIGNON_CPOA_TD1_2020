/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2 : POJO     */
/* Langage : Java & SQL           |                  */
/* Date : 26/09/2020              |                  */
/*****************************************************/

package Metier;

import java.util.List;

public class Client {
	private int id;
	private String nom;
	private String prenom;

	// Un client 'réalise' 0 ou plusieurs commandes ..
	private List<Commande> commandes;


	public Client(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Client() { }


	public int getId() {
		return id;
	}
	public void setId(int num) {
		this.id = num;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}

