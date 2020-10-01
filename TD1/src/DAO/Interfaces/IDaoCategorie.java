/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   DAO            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package DAO.Interfaces;

import java.util.List;

import Metier.Categorie;

public interface IDaoCategorie extends IDao<Categorie> {
    List<Categorie> getAllCategories();
}