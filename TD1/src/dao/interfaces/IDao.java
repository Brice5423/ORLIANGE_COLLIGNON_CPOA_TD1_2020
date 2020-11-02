package dao.interfaces;


// Interface DAO de type CRUD //
public interface IDao<T> {
    // cree :
    boolean create(T objet);

    // lire :
    T getById(int id);

    // modif :
    boolean update(T objet);

    // sup :
    boolean delete(T objet);
}
