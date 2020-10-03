/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2 : DAO      */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package DAO.Factory;

import DAO.Enum.EPersistance;
import DAO.Interfaces.IDaoCategorie;
import DAO.Interfaces.IDaoProduit;

public abstract class DaoFactory {
    public abstract IDaoCategorie getDaoCategorie();
    public abstract IDaoProduit getDaoProduit();

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
