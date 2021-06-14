package data;

import entity.Armadura;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArmaduraDAO implements DAO<Armadura> {

    public ArrayList<Armadura> selectQuery () throws SQLException {
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM armadura");
        ArrayList<Armadura> armaduras = new ArrayList<>();

        while(rs.next()) {
            armaduras.add(new Armadura(rs.getInt("num_serie"), rs.getString("modelo")));
        }
        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);
        return armaduras;
    }

    public void insertUpdate (Armadura armadura) throws SQLException {
        if(armadura == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("INSERT INTO armadura(num_serie, modelo) VALUES (?,?)");
        st.setInt(1, armadura.getNum_serie());
        st.setString(2, armadura.getModelo());
        st.executeUpdate();
        Conexion.close(st);
        Conexion.close(conn);
    }

    public void update (Armadura armadura) throws SQLException{
        if(armadura == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("UPDATE armadura SET modelo = ? where ?");
        st.setString(1, armadura.getModelo());
        st.setInt(1, armadura.getNum_serie());
        st.executeUpdate();
        Conexion.close(conn);
        Conexion.close(st);
    }

    public void deleteUpdate (Armadura armadura) throws SQLException {
        if(armadura == null)
            return;
        Connection conn = Conexion.connect();
        PreparedStatement st = conn.prepareStatement("DELETE FROM armadura WHERE num_serie = ?");
        st.setInt(1, armadura.getNum_serie());
        st.executeUpdate();
        Conexion.close(st);
        Conexion.close(conn);
    }
}
