/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   POJO           */
/* Langage : Java & SQL           |                  */
/* Date : 26/09/2020              |                  */
/*****************************************************/

package Metier;

import java.util.List;

public class Client {
	private int num;
	private String nom;
	private String prenom;

	// Un client 'réalise' 0 ou plusieurs commandes ..
	private List<Commande> commandes;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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

