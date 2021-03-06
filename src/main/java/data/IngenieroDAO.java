package data;

import entity.Ingeniero;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class IngenieroDAO implements DAO<Ingeniero>{

    public ArrayList<Ingeniero> selectQuery() throws SQLException {
        Connection conn = Conexion.connect();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT cedula, (nombre).nom_pila, (nombre).apellido1, (nombre).apellido2, telefono, (direccion).calle, (direccion).numero, (direccion).codigo_postal, (direccion).ciudad, (direccion).pais, estudios FROM ingeniero");
        ArrayList<Ingeniero> ing = new ArrayList<>();
        while (rs.next()) {
            ing.add(new Ingeniero(rs.getString("cedula"), rs.getString("nom_pila"), rs.getString("apellido1"), rs.getString("apellido2"),
                    rs.getString("telefono"), rs.getString("calle"), rs.getInt("numero"),
                    rs.getString("codigo_postal"), rs.getString("ciudad"),
                    rs.getString("pais"), rs.getString("estudios")));
        }
        Conexion.close(rs);
        Conexion.close(statement);
        Conexion.close(conn);
        return ing;
    }

    public Ingeniero searchQuery(String cedula) throws SQLException {
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("SELECT cedula, (nombre).nom_pila, (nombre).apellido1, (nombre).apellido2, telefono, (direccion).calle, (direccion).numero, (direccion).codigo_postal, (direccion).ciudad, (direccion).pais, estudios FROM ingeniero WHERE cedula = ?");
        st.setString(1, cedula);
        ResultSet rs = st.executeQuery();
        Ingeniero ingeniero = new Ingeniero(rs.getString("cedula"), rs.getString("nom_pila"), rs.getString("apellido1"), rs.getString("apellido2"),
                rs.getString("telefono"), rs.getString("calle"), rs.getInt("numero"),
                rs.getString("codigo_postal"), rs.getString("ciudad"),
                rs.getString("pais"), rs.getString("estudios"));
        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);
        return ingeniero;
    }

    public void insertUpdate(Ingeniero ing) throws SQLException{
        if(ing == null)
            return;
        Connection conn =  Conexion.connect();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO ingeniero(cedula, nombre, telefono, direccion, estudios, estado) VALUES (?, ROW(?,?,?),?, ROW(?,?,?,?,?), ?, true)");
        statement.setString(1, ing.getCedula());
        statement.setString(2, ing.getNom_pila());
        statement.setString(3, ing.getApellido1());
        statement.setString(4, ing.getApellido2());
        statement.setString(5, ing.getTelefono());
        statement.setString(6, ing.getCalle());
        statement.setInt(7, ing.getNumero());
        statement.setString(8, ing.getCodigo_postal());
        statement.setString(9, ing.getCiudad());
        statement.setString(10, ing.getPais());
        statement.setString(11, ing.getEstudios());
        statement.executeUpdate();
        Conexion.close(statement);
        Conexion.close(conn);
    }

    public void deleteUpdate (Ingeniero ing) throws SQLException{
        if(ing == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM ingeniero WHERE cedula = ?");
        statement.setString(1, ing.getCedula());
        statement.executeUpdate();
        Conexion.close(statement);
        Conexion.close(conn);
    }

    public void update (Ingeniero ing) throws SQLException {
        if(ing == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement statement = conn.prepareStatement("UPDATE ingeniero SET nombre = row(?,?,?), telefono = ?, direccion =  row(?,?,?,?,?), estudios = ? WHERE cedula = ?");
        statement.setString(1, ing.getNom_pila());
        statement.setString(2, ing.getApellido1());
        statement.setString(3, ing.getApellido2());
        statement.setString(4, ing.getTelefono());
        statement.setString(5, ing.getCalle());
        statement.setInt(6, ing.getNumero());
        statement.setString(7, ing.getCodigo_postal());
        statement.setString(8, ing.getCiudad());
        statement.setString(9, ing.getPais());
        statement.setString(10, ing.getEstudios());
        statement.setString(11, ing.getCedula());
        statement.executeUpdate();
        Conexion.close(statement);
        Conexion.close(conn);
    }

    public void safeDelete(Ingeniero ing) throws SQLException{
        if(ing == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("UPDATE ingeniero SET estado = false WHERE cedula = ?");
        st.setString(1, ing.getCedula());
        st.executeUpdate();

        Conexion.close(st);
        Conexion.close(conn);
    }


}
