package dao.interfaces;

import java.util.List;

import home.metier.Client;

public interface IDaoClient extends IDao<Client>  {
    List<Client> getAllClients();
}
