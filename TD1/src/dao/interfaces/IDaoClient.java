package dao.interfaces;


import java.util.List;

import home.metier.Client;


public interface IDaoClient extends IDao<Client>  {
    // affiche la liste de tout les clients //
    List<Client> getAllClients();

    // affiche la liste en fonction d'un filtre //
    List<Client> getByNomPrenom(String filtreNom, String filtrePrenom);
}
