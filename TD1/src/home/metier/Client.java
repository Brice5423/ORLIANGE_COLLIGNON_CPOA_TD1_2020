package home.metier;


import java.util.List;


// Pojo (Plain Old Java Object) correspondant à la classe métier 'Client'.//
public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;

	private String adrNum;
	private String adrVoie;
	private String adrCodePostal;
	private String adrVille;
	private String adrPays;

	// Un client 'réalise' 0 ou plusieurs commandes ..
	private List<Commande> commandes;


	public Client(int id, String nom, String prenom, String mail, String mdp, String adrNum, String adrVoie, String adrCodePostal, String adrVille, String adrPays) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;

		this.adrNum = adrNum;
		this.adrVoie = adrVoie;
		this.adrCodePostal = adrCodePostal;
		this.adrVille = adrVille;
		this.adrPays = adrPays;
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

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public String getAdrNum() {
		return adrNum;
	}
	public void setAdrNum(String adrNum) {
		this.adrNum = adrNum;
	}

	public String getAdrVoie() {
		return adrVoie;
	}
	public void setAdrVoie(String adrVoie) {
		this.adrVoie = adrVoie;
	}

	public String getAdrCodePostal() {
		return adrCodePostal;
	}
	public void setAdrCodePostal(String adrCodePostal) {
		this.adrCodePostal = adrCodePostal;
	}

	public String getAdrVille() {
		return adrVille;
	}
	public void setAdrVille(String adrVille) {
		this.adrVille = adrVille;
	}

	public String getAdrPays() {
		return adrPays;
	}
	public void setAdrPays(String adrPays) {
		this.adrPays = adrPays;
	}


	public void setAdresse(String num, String voie, String codePostal, String ville, String pays) {
		this.adrNum = num;
		this.adrVoie = voie;
		this.adrCodePostal = codePostal;
		this.adrVille = ville;
		this.adrPays = pays;
	}


	@Override
	public String toString() {
		return "id = " + id + ", nom = " + nom + ", prenom = " + prenom;
	}

	public String toStringController() {
		return this.nom + " " + this.prenom ;
	}
}

