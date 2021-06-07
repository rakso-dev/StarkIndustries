package data;

import entity.Fabricante;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FabricanteDAO implements DAO<Fabricante> {
    @Override
    public ArrayList<Fabricante> selectQuery() throws SQLException {
        return null;
    }

    @Override
    public void insertUpdate(Fabricante element) throws SQLException {

    }

    @Override
    public void update(Fabricante element) throws SQLException {

    }

    @Override
    public void deleteUpdate(Fabricante element) throws SQLException {

    }
}
