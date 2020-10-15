/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2 : DAO      */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package DAO.Interfaces;

import java.util.List;

import Main.Metier.Categorie;

public interface IDaoCategorie extends IDao<Categorie> {
    List<Categorie> getAllCategories();
}
