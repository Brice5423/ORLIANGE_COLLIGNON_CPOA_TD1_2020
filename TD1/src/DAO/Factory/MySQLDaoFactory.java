/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   DAO            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package DAO.Factory;

import DAO.Interfaces.IDaoCategorie;
import DAO.Interfaces.IDaoProduit;

public class MySQLDaoFactory extends DaoFactory {
    @Override
    public IDaoCategorie getDaoCategorie() {
        return null;
    }

    @Override
    public IDaoProduit getDaoProduit() {
        return null;
    }
}
