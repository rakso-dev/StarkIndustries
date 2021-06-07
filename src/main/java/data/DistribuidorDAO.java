package data;

import entity.Distribuidor;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DistribuidorDAO implements DAO<Distribuidor> {
    @Override
    public ArrayList<Distribuidor> selectQuery() throws SQLException {
        return null;
    }

    @Override
    public void insertUpdate(Distribuidor element) throws SQLException {

    }

    @Override
    public void update(Distribuidor element) throws SQLException {

    }

    @Override
    public void deleteUpdate(Distribuidor element) throws SQLException {

    }
}
