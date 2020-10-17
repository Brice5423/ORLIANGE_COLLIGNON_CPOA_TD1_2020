package DAO.Factory;

import DAO.Interfaces.IDaoCategorie;
import DAO.Interfaces.IDaoClient;
import DAO.Interfaces.IDaoProduit;
import DAO.Memoire.MySqlCategorieDao;
import DAO.Memoire.MySqlClientDao;
import DAO.Memoire.MySqlProduitDao;

public class MySQLDaoFactory extends DaoFactory {
    @Override
    public IDaoCategorie getDaoCategorie() {
        return MySqlCategorieDao.getInstance();
    }

    @Override
    public IDaoClient getDaoClient() {
        return MySqlClientDao.getInstance();
    }

    @Override
    public IDaoProduit getDaoProduit() {
        return MySqlProduitDao.getInstance();
    }
}
