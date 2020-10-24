package dao.interfaces;

import java.util.List;

import home.metier.Commande;

public interface IDaoCommande extends IDao<Commande> {
    List<Commande> getAllCommande();
}
