package data;

import entity.Cliente;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO implements DAO<Cliente> {

    @Override
    public ArrayList<Cliente> selectQuery() throws SQLException{
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT rfc, (nombre).nom_pila, (nombre).apellido1, (nombre).apellido2, telefono, (direccion).calle, (direccion).numero, (direccion).codigo_postal, (direccion).ciudad, (direccion).pais FROM cliente");
        ArrayList<Cliente> clientes = new ArrayList<>();
        while(rs.next())
            clientes.add(new Cliente(rs.getString("rfc"), rs.getString("nom_pila"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("telefono"), rs.getString("calle"), rs.getInt("numero"), rs.getString("codigo_postal"), rs.getString("ciudad"), rs.getString("pais")));
        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);
        return clientes;
    }

    @Override
    public void insertUpdate(Cliente element) throws SQLException{
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("INSERT INTO cliente(rfc, nombre, telefono, direccion) VALUES (?, row(?,?,?), ?, row(?,?,?,?,?))");
        st.setString(1, element.getRfc());
        st.setString(2, element.getNom_pila());
        st.setString(3, element.getApellido1());
        st.setString(4, element.getApellido2());
        st.setString(5, element.getTelefono());
        st.setString(6, element.getCalle());
        st.setInt(7, element.getNumero());
        st.setString(8, element.getCodigo_postal());
        st.setString(9, element.getCiudad());
        st.setString(10, element.getPais());
        st.executeUpdate();
        Conexion.close(st);
        Conexion.close(conn);
    }

    @Override
    public void update(Cliente element) throws SQLException{
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("UPDATE cliente SET nombre = row(?,?,?), telefono = ?, direccion = row(?,?,?,?,?) WHERE rfc = ?");
        st.setString(1, element.getNom_pila());
        st.setString(2, element.getApellido1());
        st.setString(3, element.getApellido2());
        st.setString(4, element.getTelefono());
        st.setString(5, element.getCalle());
        st.setInt(6, element.getNumero());
        st.setString(7, element.getCodigo_postal());
        st.setString(8, element.getCiudad());
        st.setString(9, element.getPais());
        st.setString(10, element.getRfc());
        st.executeUpdate();
        Conexion.close(st);
        Conexion.close(conn);
    }

    @Override
    public void deleteUpdate(Cliente element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        st.executeUpdate("DELETE FROM cliente WHERE rfc = " + element.getRfc());

        Conexion.close(st);
        Conexion.close(conn);
    }
}
