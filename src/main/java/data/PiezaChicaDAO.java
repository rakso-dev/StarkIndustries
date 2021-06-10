package data;
import entity.PiezaChica;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PiezaChicaDAO implements DAO<PiezaChica> {
    @Override
    public ArrayList<PiezaChica> selectQuery() throws SQLException {
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, linea, color, (medidas).largo, (medidas).ancho, (medidas).alto, r_fabricante, r_armadura FROM pieza_chica");
        ArrayList<PiezaChica> piezas_chicas = new ArrayList<>();
        while(rs.next())
            piezas_chicas.add(new PiezaChica(rs.getInt("id"), rs.getString("linea"), rs.getString("color"), rs.getDouble("largo"), rs.getDouble("ancho"), rs.getDouble("alto"), rs.getString("r_fabricante"), rs.getInt("r_armadura")));

        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);
        return piezas_chicas;
    }

    @Override
    public void insertUpdate(PiezaChica element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("INSERT INTO pieza_chica(linea, color, medidas, r_fabricante, r_armadura) VALUES (?, ?, row ( ?,?,? ), ?, ?)");
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
    public void update(PiezaChica element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("UPDATE pieza_chica SET linea = ?, color = ?, medidas = row(?, ? ,?), r_armadura = ?, r_fabricante = ? WHERE id = ?");
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
    public void deleteUpdate(PiezaChica element) throws SQLException {
        if(element == null)
            return;
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        st.executeUpdate("DELETE FROM pieza_chica WHERE id = " + element.getId());

        Conexion.close(st);
        Conexion.close(conn);
    }
}
