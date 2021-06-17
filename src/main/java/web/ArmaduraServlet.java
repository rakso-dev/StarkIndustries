package web;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.sql.SQLException;

import entity.Armadura;
import data.ArmaduraDAO;

@WebServlet(name = "ArmaduraServlet", urlPatterns = {"/Armadura"})
public class ArmaduraServlet extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArmaduraDAO dao = new ArmaduraDAO();
        try {
            List<Armadura> armaduras = dao.selectQuery();
            request.setAttribute("armaduras", armaduras);
            request.getRequestDispatcher("/Armadura.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int opt = Integer.parseInt(request.getParameter("option"));
        Armadura armadura = new Armadura();
        armadura.setNum_serie(Integer.parseInt(request.getParameter("numSerie")));
        armadura.setModelo(request.getParameter("modelo"));

        switch (opt) {
            case 1:
                if(!insert(armadura))
                    break;
                response.sendRedirect("InsertarArmadura.jsp");
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                break;
        }
    }

    private boolean insert (Armadura a) {
        if(a.getNum_serie() < 0)
            return false;
        if(a.getModelo().isEmpty())
            return false;
        ArmaduraDAO dao = new ArmaduraDAO();
        try{
            dao.insertUpdate(a);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
