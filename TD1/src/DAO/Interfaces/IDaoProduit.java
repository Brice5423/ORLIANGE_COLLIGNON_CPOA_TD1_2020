/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   DAO            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package DAO.Interfaces;

import java.util.List;

import Metier.Produit;

// Interface DAO produit qui étend l'interface principale CRUD //
public interface IDaoProduit extends IDao<Produit> {
    List<Produit> getAllProduits();
}
