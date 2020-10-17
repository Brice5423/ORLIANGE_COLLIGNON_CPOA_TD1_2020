package DAO.Factory;

import DAO.Interfaces.IDaoCategorie;
import DAO.Interfaces.IDaoClient;
import DAO.Interfaces.IDaoProduit;
import DAO.Memoire.ListeMemoireCategorieDao;
import DAO.Memoire.ListeMemoireClientDao;
import DAO.Memoire.ListeMemoireProduitDao;

public class ListeMemoireDaoFactory extends DaoFactory {
    @Override
    public IDaoCategorie getDaoCategorie() {
        return ListeMemoireCategorieDao.getInstance();
    }

    @Override
    public IDaoClient getDaoClient() {
        return ListeMemoireClientDao.getInstance();
    }

    @Override
    public IDaoProduit getDaoProduit() {
        return ListeMemoireProduitDao.getInstance();
    }
}
