/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   DAO            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package DAO.Interfaces;

// Interface DAO de type CRUD //
public interface IDao<T> {
    // Create :
    abstract boolean create(T objet);

    // Read :
    abstract T getById(int id);

    // Update :
    abstract boolean update(T objet);

    // Delete :
    abstract boolean delete(T objet);
}
