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
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT rfc, nombre, (direccion).calle, (direccion).numero, (direccion).codigo_postal, (direccion).ciudad, (direccion).pais FROM fabricante");
        ArrayList<Fabricante> fabricantes = new ArrayList<>();
        while(rs.next())
            fabricantes.add(new Fabricante(rs.getString("rfc"), rs.getString("nombre"), rs.getString("calle"), rs.getInt("numero"), rs.getString("codigo_postal"), rs.getString("ciudad"), rs.getString("pais")));
        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);
        return fabricantes;
    }

    @Override
    public void insertUpdate(Fabricante element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("INSERT INTO fabricante(rfc, nombre, direccion) VALUES (?, ?, row(?,?,?,?,?))");
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
    public void update(Fabricante element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("UPDATE fabricante SET nombre = ?, direccion = row(?,?,?,?,?) WHERE rfc = ?");
        st.setString(1, element.getNombre());
        st.setString(2, element.getCalle());
        st.setInt(3, element.getNumero());
        st.setString(4, element.getCodigo_postal());
        st.setString(5, element.getCiudad());
        st.setString(6,element.getPais());
        st.setString(7, element.getRfc());
        st.executeUpdate();

        Conexion.close(st);
        Conexion.close(conn);
    }

    @Override
    public void deleteUpdate(Fabricante element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        st.executeUpdate("DELETE FROM fabricante WHERE rfc = " + element.getRfc());

        Conexion.close(st);
        Conexion.close(conn);
    }
}
