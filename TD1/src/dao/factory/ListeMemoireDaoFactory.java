package dao.factory;

import dao.interfaces.IDaoCategorie;
import dao.interfaces.IDaoClient;
import dao.interfaces.IDaoProduit;
import dao.interfaces.IDaoCommande;
import dao.memoire.ListeMemoireCategorieDao;
import dao.memoire.ListeMemoireClientDao;
import dao.memoire.ListeMemoireProduitDao;
import dao.memoire.ListeMemoireCommandeDao;

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

    @Override
    public IDaoCommande getDaoCommande() {
        return ListeMemoireCommandeDao.getInstance();
    }
}
