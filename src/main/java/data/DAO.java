package data;
import java.util.ArrayList;
import java.sql.SQLException;

public interface DAO<E> {
    public ArrayList<E> selectQuery () throws SQLException;
    public void insertUpdate (E element) throws SQLException;
    public void update (E element) throws SQLException;
    public void deleteUpdate(E element) throws SQLException;
}
