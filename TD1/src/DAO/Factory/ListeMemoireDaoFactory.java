/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2 : DAO      */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package DAO.Factory;

import DAO.Interfaces.IDaoCategorie;
import DAO.Interfaces.IDaoProduit;
import DAO.Memoire.ListeMemoireCategorieDao;
import DAO.Memoire.ListeMemoireProduitDao;

public class ListeMemoireDaoFactory extends DaoFactory {
    @Override
    public IDaoCategorie getDaoCategorie() {
        return ListeMemoireCategorieDao.getInstance();
    }

    @Override
    public IDaoProduit getDaoProduit() {
        return ListeMemoireProduitDao.getInstance();
    }
}
