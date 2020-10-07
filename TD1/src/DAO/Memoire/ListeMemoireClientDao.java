package DAO.Memoire;

import DAO.Interfaces.IDaoClient;
import Metier.Client;

import java.util.ArrayList;
import java.util.List;

public class ListeMemoireClientDao implements IDaoClient {

    public static IDaoClient getInstance() {
        return null;
    }

    @Override
    public List<Client> getAllClient() {
        return null;
    }

    @Override
    public boolean create(Client objet) {
        return false;
    }

    @Override
    public Client getById(int id) {
        return null;
    }

    @Override
    public boolean update(Client objet) {
        return false;
    }

    @Override
    public boolean delete(Client objet) {
        return false;
    }
}
