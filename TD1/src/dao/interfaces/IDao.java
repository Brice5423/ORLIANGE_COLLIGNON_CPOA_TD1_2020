package dao.interfaces;


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
