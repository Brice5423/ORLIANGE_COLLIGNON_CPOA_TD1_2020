package DAO.Interfaces;

import java.util.List;

import Main.Metier.Client;

public interface IDaoClient extends IDao<Client>  {
    List<Client> getAllClients();
}
