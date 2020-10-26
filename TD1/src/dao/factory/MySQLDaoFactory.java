package dao.factory;

import dao.interfaces.IDaoCategorie;
import dao.interfaces.IDaoClient;
import dao.interfaces.IDaoProduit;
import dao.interfaces.IDaoCommande;
import dao.mysql.MySqlCategorieDao;
import dao.mysql.MySqlClientDao;
import dao.mysql.MySqlProduitDao;
import dao.mysql.MySqlCommandeDao;

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

    @Override
    public IDaoCommande getDaoCommande() {
        return MySqlCommandeDao.getInstance();
    }
}
