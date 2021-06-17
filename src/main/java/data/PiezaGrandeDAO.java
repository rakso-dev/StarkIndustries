package data;

import entity.PiezaGrande;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PiezaGrandeDAO implements DAO<PiezaGrande>{

    @Override
    public ArrayList<PiezaGrande> selectQuery() throws SQLException {
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, linea, color, (medidas).largo, (medidas).ancho, (medidas).alto, r_fabricante, r_armadura FROM pieza_grande");
        ArrayList<PiezaGrande> piezas_grandes = new ArrayList<>();
        while(rs.next())
            piezas_grandes.add(new PiezaGrande(rs.getInt("id"), rs.getString("linea"), rs.getString("color"), rs.getDouble("largo"), rs.getDouble("ancho"), rs.getDouble("alto"), rs.getString("r_fabricante"), rs.getInt("r_armadura")));

        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);
        return piezas_grandes;
    }

    @Override
    public void insertUpdate(PiezaGrande element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("INSERT INTO pieza_grande(linea, color, medidas, r_fabricante, r_armadura) VALUES (?, ?, row ( ?,?,? ), ?, ?)");
        st.setString(1, element.getLinea());
        st.setString(2, element.getColor());
        st.setDouble(3, element.getLargo());
        st.setDouble(4, element.getAncho());
        st.setDouble(5, element.getAlto());
        st.setString(6, element.getR_fabricante());
        st.setInt(7, element.getR_armadura());
        st.executeUpdate();

        Conexion.close(st);
        Conexion.close(conn);
    }

    @Override
    public void update(PiezaGrande element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("UPDATE pieza_grande SET linea = ?, color = ?, medidas = row(?, ? ,?), r_armadura = ?, r_fabricante = ? WHERE id = ?");
        st.setString(1, element.getLinea());
        st.setString(2, element.getColor());
        st.setDouble(3, element.getLargo());
        st.setDouble(4, element.getAncho());
        st.setDouble(5, element.getAlto());
        st.setString(6, element.getR_fabricante());
        st.setInt(7, element.getR_armadura());
        st.setInt(8, element.getId());
        st.executeUpdate();

        Conexion.close(st);
        Conexion.close(conn);
    }

    @Override
    public void deleteUpdate(PiezaGrande element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        st.executeUpdate("DELETE FROM pieza_grande WHERE id = " + element.getId());

        Conexion.close(st);
        Conexion.close(conn);
    }
}
