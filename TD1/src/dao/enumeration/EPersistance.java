package dao.enumeration;

public enum EPersistance {
    MYSQL(0), LISTE_MEMOIRE(1);

    private int code;

    EPersistance(int code) {
        this.code = code;
    }
}
