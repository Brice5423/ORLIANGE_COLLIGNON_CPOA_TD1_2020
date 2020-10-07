/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2 : DAO      */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

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
        return null;
    }

    @Override
    public IDaoClient getDaoClient() {
        return null;
    }

    @Override
    public IDaoProduit getDaoProduit() {
        return null;
    }
}
