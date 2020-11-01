package dao.interfaces;


import java.util.List;

import home.metier.Commande;


// Interface DAO commande qui étend l'interface principale CRUD //
public interface IDaoCommande extends IDao<Commande> {
    // affiche la liste de tout les commandes //
    List<Commande> getAllCommande();
}
