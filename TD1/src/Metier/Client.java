package Metier;

import java.util.List;

/**
 * Pojo classe métier Client :
 * 
 * @author stephane.joyeux
 *
 */
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

