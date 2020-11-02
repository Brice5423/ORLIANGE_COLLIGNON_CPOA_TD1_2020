package dao.memoire;


import dao.interfaces.IDaoClient;
import home.metier.Client;

import java.util.ArrayList;
import java.util.List;


public class ListeMemoireClientDao implements IDaoClient {
    private static IDaoClient instance;
    private static List<Client> donnees;


    public static IDaoClient getInstance() {
        if (instance == null) {
            instance = new ListeMemoireClientDao();
        }
        return instance;
    }

    private ListeMemoireClientDao() {
        // Pour éviter instanciation directe :
        this.donnees = new ArrayList<Client>();
        this.donnees.add(new Client(1, "ORLIANGE", "Brice", "orl.bri@liste.com", "jetaime", "45", "rue", "54789", "cool", "happy"));
        this.donnees.add(new Client(2, "COLLIGNON", "Nicolas", "col.nic@liste.com", "bisous", "36", "avenu", "57852", "nop", "hihi"));
    }


    @Override // Lire tout
    public List<Client> getAllClients() {
        return (ArrayList<Client>) this.donnees;
    }


    @Override // Filtre par Nom et/ou Prenom
    public List<Client> getByNomPrenom(String filtreNom, String filtrePrenom) {
        List<Client> listeFiltre;
        listeFiltre = new ArrayList<Client>();
        String filtreNomUp = filtreNom.toUpperCase();
        String filtrePrenomLow = filtrePrenom.toLowerCase();
        System.out.println("Filtre : Nom : " + filtreNomUp + " - Prenom : " + filtrePrenomLow);

        for (Client client : donnees) {
            String testNom = client.getNom();
            String testPrenom = client.getPrenom().toLowerCase();
            System.out.println("Test : Nom : " + testNom + " - Prenom : " + testPrenom);

            if ((testNom == filtreNomUp) || (testPrenom == filtrePrenomLow)) {
                listeFiltre.add(client);
                System.out.println(client.toString());
            }
        }
        System.out.println();
        return listeFiltre;
    }


    @Override // Cree
    public boolean create(Client objet) {
        if (donnees == null) {
            donnees = new ArrayList<>();
        }

        objet.setId(1);
        for (Client client : donnees) {
            if (client.getId() == objet.getId()) {
                objet.setId(objet.getId()+1);
            }
        }

        return this.donnees.add(objet);
    }

    @Override // Lire
    public Client getById(int id) {
        if (donnees != null && !donnees.isEmpty()) {
            // Itérator sur la liste des produits :
            for (Client client : donnees) {
                if (client.getId() == id) {
                    return client;
                }
            }
        }
        return null;
    }

    @Override // Modif
    public boolean update(Client objet) {
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un client inexistante");
        } else {
            this.donnees.set(idx, objet);
        }
        return true;
    }

    @Override // Sup
    public boolean delete(Client objet) {
        Client supprime;

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'un client inexistante");
        } else {
            supprime = this.donnees.remove(idx);
        }
        return objet.equals(supprime);
    }
}
