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
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT rfc, nombre, (direccion).calle, (direccion).numero, (direccion).codigo_postal, (direccion).ciudad, (direccion).pais FROM distribuidor");
        ArrayList<Distribuidor> distribuidores = new ArrayList<>();

        while(rs.next())
            distribuidores.add(new Distribuidor(rs.getString("rfc"), rs.getString("nombre"), rs.getString("calle"), rs.getInt("numero"), rs.getString("codigo_postal"), rs.getString("ciudad"), rs.getString("pais")));
        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);
        return distribuidores;
    }

    @Override
    public void insertUpdate(Distribuidor element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("INSERT INTO distribuidor(rfc, nombre, direccion) VALUES ?, ?, row(?,?,?,?,?)");
        st.setString(1, element.getRfc());
        st.setString(2, element.getNombre());
        st.setString(3, element.getCalle());
        st.setInt(4, element.getNumero());
        st.setString(5, element.getCodigo_postal());
        st.setString(6, element.getCiudad());
        st.setString(7, element.getPais());
        st.executeUpdate();

        Conexion.close(st);
        Conexion.close(conn);
    }

    @Override
    public void update(Distribuidor element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("UPDATE distribuidor SET nombre = ?, direccion = row(?,?,?,?,?) WHERE rfc = ?");
        st.setString(1, element.getNombre());
        st.setString(2, element.getCalle());
        st.setInt(3, element.getNumero());
        st.setString(4, element.getCodigo_postal());
        st.setString(5, element.getCiudad());
        st.setString(6, element.getPais());
        st.setString(7, element.getRfc());
        st.executeUpdate();

        Conexion.close(st);
        Conexion.close(conn);
    }

    @Override
    public void deleteUpdate(Distribuidor element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        st.executeUpdate("DELETE FROM distibuidor WHERE rfc = " + element.getRfc());

        Conexion.close(st);
        Conexion.close(conn);
    }
}
