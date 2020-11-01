package dao.factory;


import dao.enumeration.EPersistance;
import dao.interfaces.IDaoCategorie;
import dao.interfaces.IDaoCommande;
import dao.interfaces.IDaoProduit;
import dao.interfaces.IDaoClient;


public abstract class DaoFactory {
    public abstract IDaoCategorie getDaoCategorie();
    public abstract IDaoProduit getDaoProduit();
    public abstract IDaoClient getDaoClient();
    public abstract IDaoCommande getDaoCommande();

    public static DaoFactory getDAOFactory(EPersistance cible) {
        DaoFactory daoF = null;
        switch (cible) {
            case MYSQL:
                daoF = new MySQLDaoFactory();
                break;
            case LISTE_MEMOIRE:
                daoF = new ListeMemoireDaoFactory();
                break;
        }
        return daoF;
    }
}
