/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2 : DAO      */
/* Langage : Java & SQL           |                  */
/* Date : 07/10/2020              |                  */
/*****************************************************/

package DAO.Interfaces;

import java.util.List;

import Metier.Client;

public interface IDaoClient extends IDao<Client>  {
    List<Client> getAllClients();
}
