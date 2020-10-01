/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   DAO            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package DAO.Enum;

public enum EPersistance {
    MYSQL(0), LISTE_MEMOIRE(1);

    private int code;

    EPersistance(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }


    EPersistance getTypeFromCode(int code) {
        if (code == 0) {
            return MYSQL;
        }
        return LISTE_MEMOIRE;
    }
}
