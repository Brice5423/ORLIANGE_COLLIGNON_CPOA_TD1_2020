/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   DAO            */
/* Langage : Java & SQL           |                  */
/* Date : 07/10/2020              |                  */
/*****************************************************/

package DAO.Memoire;

import DAO.Interfaces.IDaoClient;
import Metier.Client;

import java.util.ArrayList;
import java.util.List;

public class ListeMemoireClientDao implements IDaoClient {
    private static IDaoClient instance;
    private List<Client> donnees;

    public static IDaoClient getInstance() {
        if (instance == null) {
            instance = new ListeMemoireClientDao();
        }
        return instance;
    }

    private ListeMemoireClientDao() {
        // Pour éviter instanciation directe :
        this.donnees = new ArrayList<Client>();
        this.donnees.add(new Client(2, "Niconii", "Nico"));
        this.donnees.add(new Client(6, "Gogo", "Gauthier"));
        this.donnees.add(new Client(12, "Yuyu", "Irma"));
    }


    @Override
    public List<Client> getAllClient() {
        return (ArrayList<Client>) this.donnees;
    }


    @Override
    public boolean create(Client objet) {
        objet.setId(3);
        while (this.donnees.contains(objet)) {
            objet.setId(objet.getId() + 1);
        }
        return this.donnees.add(objet);
    }

    @Override
    public Client getById(int id) {
        if (donnees != null && !donnees.isEmpty()) {
            // Itérator sur la liste des produits :
            for (Client produit : donnees) {
                if (produit.getId() == id) {
                    return produit;
                }
            }
        }

        return null;
    }

    @Override
    public boolean update(Client objet) {
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'une categorie inexistante");
        } else {
            this.donnees.set(idx, objet);
        }

        return true;
    }

    @Override
    public boolean delete(Client objet) {
        Client supprime;

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'une categorie inexistante");
        } else {
            supprime = this.donnees.remove(idx);
        }
        return objet.equals(supprime);
    }
}
