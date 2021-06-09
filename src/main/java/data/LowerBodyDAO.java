package data;

import entity.LowerBody;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LowerBodyDAO implements DAO<LowerBody> {
    @Override
    public ArrayList<LowerBody> selectQuery() throws SQLException {
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, linea, color, (medidas).largo, (medidas).ancho, (medidas).alto, r_fabricante, r_armadura, altura_suelo FROM lower_body");
        ArrayList<LowerBody> piezas = new ArrayList<>();
        while (rs.next())
            piezas.add(new LowerBody(rs.getInt("id"), rs.getString("linea"), rs.getString("color"), rs.getDouble("largo"), rs.getDouble("ancho"), rs.getDouble("alto"), rs.getString("r_armadura"), rs.getInt("r_armadura"), rs.getDouble("altura_suelo")));
        return piezas;
    }

    @Override
    public void insertUpdate(LowerBody element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("INSERT INTO lower_body(linea, color, medidas, r_fabricante, r_armadura, altura_suelo) VALUES (?, ?, row(?,?,?), ?, ?, ?)");
        st.setString(1, element.getLinea());
        st.setString(2, element.getColor());
        st.setDouble(3, element.getLargo());
        st.setDouble(4, element.getAncho());
        st.setDouble(5, element.getAlto());
        st.setString(6, element.getR_fabricante());
        st.setInt(7, element.getR_armadura());
        st.setDouble(8, element.getAltura_suelo());
        st.executeUpdate();

        Conexion.close(st);
        Conexion.close(conn);
    }

    @Override
    public void update(LowerBody element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("UPDATE lower_body SET linea = ?, color = ?, medidas = row(?,?,?), r_fabricante = ?, r_armadura = ?, altura_suelo = ? WHERE id = ?");
        st.setString(1, element.getLinea());
        st.setString(2, element.getColor());
        st.setDouble(3, element.getLargo());
        st.setDouble(4, element.getAncho());
        st.setDouble(5, element.getAlto());
        st.setString(6, element.getR_fabricante());
        st.setInt(7, element.getR_armadura());
        st.setDouble(8, element.getAltura_suelo());
        st.setInt(9, element.getId());
        st.executeUpdate();

        Conexion.close(st);
        Conexion.close(conn);
    }

    @Override
    public void deleteUpdate(LowerBody element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        st.executeUpdate("DELETE FROM lower_body WHERE id = " + element.getId());

        Conexion.close(st);
        Conexion.close(conn);
    }
}
